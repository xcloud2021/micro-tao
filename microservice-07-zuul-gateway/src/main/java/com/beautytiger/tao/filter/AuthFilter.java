package com.beautytiger.tao.filter;

import com.beautytiger.tao.entities.Token;
import com.beautytiger.tao.entities.User;
import com.beautytiger.tao.service.UserClientService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthFilter  extends ZuulFilter {

    @Autowired
    private UserClientService service;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        Logger logger = LoggerFactory.getLogger(getClass());
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        // 禁止用户自己设置 userId header
        String userId = request.getHeader("userId");
        if (userId != null && !userId.equals("")) {
            logger.warn("userId header is set, this is not allowed");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            try {
                context.getResponse().setContentType("text/html;charset=UTF-8");
                context.getResponse().getWriter().write("请求错误");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

//        String token = request.getHeader("userToken");
        String token = request.getHeader("X-Token");
        if (token == null || token.equals("")) {
            return null;
        }
        logger.info("userToken: " + token);
        User user = service.verify(new Token(token));
        logger.info(String.valueOf(user));
        if (user != null && user.getId() > 0) {
            logger.info("userId: " + user.getId());
            context.addZuulRequestHeader("userId", user.getId().toString());
        }
        return null;
    }
}
