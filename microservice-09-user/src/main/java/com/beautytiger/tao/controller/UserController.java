package com.beautytiger.tao.controller;

import com.beautytiger.tao.entities.Token;
import com.beautytiger.tao.entities.User;
import com.beautytiger.tao.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RefreshScope
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Resource
    private RedisTemplate<String, Long> redisTemplate;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public Token login(@RequestBody User user) {
        User realUser = userService.login(user);
        if (realUser == null || realUser.getId() < 1) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        // todo: new save uuid -> user_id and set ttl
        String tokenStr = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(tokenStr, realUser.getId());
        return new Token(tokenStr);
    }

    @RequestMapping(value="/verify", method= RequestMethod.POST)
    public User verify(@RequestBody Token token) {
        logger.info("token: "+ token.getToken());
        Long userId = redisTemplate.opsForValue().get(token.getToken());
        if (userId == null || userId < 1) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return userService.get(userId);
    }

    @RequestMapping(value="/logout", method= RequestMethod.POST)
    public boolean logout(@RequestBody User user) {
        return userService.logout(user.getAccount());
    }

    @HystrixCommand(fallbackMethod = "getFallBack")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Long id) {

        User user =  userService.get(id);
        // 服务异常，触发fallback
        if (user == null) {
            throw new RuntimeException("ID=" + id + "不存在");
        }
        return user;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<User> list() {
        return userService.list();
    }

    public User getFallBack(@PathVariable("id") Long id) {
        return new User("ID=" + id + "用户不存在", "");
    }
}
