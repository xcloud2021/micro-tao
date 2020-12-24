package com.beautytiger.tao.service;

import com.beautytiger.tao.entities.User;

import java.util.List;


public interface UserService {
    boolean register(User user);
    User get(Long id);
    User login(User user);
    boolean logout(String account);
    boolean modify(User user);
    List<User> list();
}
