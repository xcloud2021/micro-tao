package com.beautytiger.tao.controller;

import com.beautytiger.tao.entities.Product;
import com.beautytiger.tao.entities.User;
import com.beautytiger.tao.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public boolean login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping(value="/logout", method= RequestMethod.POST)
    public boolean logout(@RequestBody User user) {
        return userService.logout(user.getAccount());
    }

    @HystrixCommand(fallbackMethod = "getFallBack")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Long id) {

        User user =  userService.get(id);
        // 服务异常，出发fallback
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
