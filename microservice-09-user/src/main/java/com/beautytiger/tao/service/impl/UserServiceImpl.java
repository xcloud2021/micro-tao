package com.beautytiger.tao.service.impl;

import com.beautytiger.tao.entities.User;
import com.beautytiger.tao.mapper.UserMapper;
import com.beautytiger.tao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public User get(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public boolean login(User user) {
        User realUser = userMapper.login(user.getAccount(), user.getPasswd());
        if (realUser != null && realUser.getId() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean logout(String account) {
        return true;
    }

    @Override
    public boolean modify(User user) {
        return true;
    }

    @Override
    public List<User> list() {
        return userMapper.findAll();
    }
}
