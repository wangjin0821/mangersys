package com.wiggin.mangersys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
			.maxAge(3600)
			.allowCredentials(true);
	}
}
