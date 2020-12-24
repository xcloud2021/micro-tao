package com.beautytiger.tao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("token info is null, login check failed");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(200);
            try {
                context.getResponse().setContentType("text/html;charset=UTF-8");
                context.getResponse().getWriter().write("请先登录再操作");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("login check passed");
        return null;
    }
}
