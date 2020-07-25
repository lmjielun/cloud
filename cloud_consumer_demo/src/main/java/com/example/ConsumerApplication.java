package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//在启动类上开启Eureka客户端功能
@EnableDiscoveryClient //来开启Eureka客户端功能
//@EnableCircuitBreaker//启用断路器，也就是熔断功能
@EnableFeignClients // 开启Feign功能
public class ConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
