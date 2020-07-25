package com.yzit.shop.controller;

import com.yzit.shop.entity.User;
import com.yzit.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping("user/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

}
