package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("熔断处理异常");
        return user;
    }
}
