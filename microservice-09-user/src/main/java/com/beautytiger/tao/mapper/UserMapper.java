package com.beautytiger.tao.mapper;

import com.beautytiger.tao.entities.User;

import java.util.List;

//@Mapper  // 或者在启动类上加注解 @MapperScan
public interface UserMapper {

    User findById(Long id);
    User findByName(String account);
    User login(String account, String passwd);
    List<User> findAll();
}