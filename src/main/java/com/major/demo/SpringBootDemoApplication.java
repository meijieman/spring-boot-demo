package com.major.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

//@SpringBootApplication
// 扫描 mybatis 包路径
@MapperScan(basePackages = "com.major.demo.mapper")
// 扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages = {"com.major.demo", "org.n3r.idworker"})
@EnableAutoConfiguration
// 开启定时任务
@EnableScheduling
// 开启异步调用方法
@EnableAsync
public class SpringBootDemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
