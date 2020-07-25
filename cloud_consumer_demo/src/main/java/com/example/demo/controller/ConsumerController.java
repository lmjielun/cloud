package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("consumer")
public class ConsumerController {

    // 注入刚才开发的UserFeignClient接口
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "user/{id}",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    //@HystrixCommand(fallbackMethod = "findByIdFallback")
    public User getUserById(@PathVariable("id") Integer id){

        // 直接调用userFeignClient，获取远程连接，获取对象
        User user = this.userFeignClient.findById(id);

        // 返回
        return user;
    }

    // fallbackMethod中指定的方法，注意，此方法的返回值，参数必须与原方法一致
  /*  public User findByIdFallback( Integer id){
        User user = new User();
        user.setId(id.longValue());
        user.setUsername("失败的信息");
        return user;
    }*/
}
