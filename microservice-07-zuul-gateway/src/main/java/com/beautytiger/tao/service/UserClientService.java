package com.beautytiger.tao.service;

import com.beautytiger.tao.entities.Token;
import com.beautytiger.tao.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${service.microservice-user.name}", url="${service.microservice-user.url}")
public interface UserClientService {

    @RequestMapping(value = "/api/v1/user/verify", method = RequestMethod.POST)
    User verify(@RequestBody Token token);
}
