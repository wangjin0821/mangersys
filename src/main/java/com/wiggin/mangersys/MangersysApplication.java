package com.wiggin.mangersys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.wiggin.mangersys.domain.mapper")
public class MangersysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangersysApplication.class, args);
	}
}
