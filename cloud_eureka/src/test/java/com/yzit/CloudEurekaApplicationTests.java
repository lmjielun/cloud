package com.yzit;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CloudEurekaApplicationTests {

	// 注入负载均衡类里的 RibbonLoadBalancerClient对象
	@Autowired
	RibbonLoadBalancerClient client;

	@Test
	public void test(){
		for (int i = 0; i < 100; i++) {
			ServiceInstance instance = this.client.choose("user-service-provider");
			System.out.println(instance.getHost() + ":" + instance.getPort());
		}
	}

}
