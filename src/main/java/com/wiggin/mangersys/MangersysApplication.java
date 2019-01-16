package com.wiggin.mangersys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wiggin.mangersys.domain.mapper")
public class MangersysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangersysApplication.class, args);
	}
}
