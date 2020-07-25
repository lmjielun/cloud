package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *   首先这是一个接口，Feign会通过动态代理，帮我们生成实现类。这点跟mybatis的mapper很像
 *  @FeignClient，声明这是一个Feign客户端，类似@Mapper注解。同时通过value属性指定服务名称
 *  接口中的定义方法，完全采用SpringMVC的注解，Feign会根据注解帮我们生成URL，并访问获取结果
 */
@FeignClient(value = "user-service-provider",fallback = UserFeignClientFallback.class) // 指向Eureka里的【服务者】注册的应用名称
public interface UserFeignClient {

    // 定义接口，访问方法Get 路径接参
    @GetMapping("user/{id}")
    // 路径接参 方法参数要和服务端的保持一致
    public User findById(@PathVariable("id") Integer id);
}
