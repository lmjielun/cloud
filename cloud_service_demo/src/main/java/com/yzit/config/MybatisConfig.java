package com.yzit.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yzit.shop.dao")
public class MybatisConfig {
}
