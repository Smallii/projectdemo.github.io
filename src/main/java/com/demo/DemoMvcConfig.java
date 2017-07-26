/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Smalli
 */
@Configuration
public class DemoMvcConfig extends WebMvcConfigurerAdapter {
    @Override
	public void addCorsMappings(CorsRegistry registry) {
            System.out.println("接收跨域请求");
		registry.addMapping("/**").allowedOrigins("*")
				.allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
				.allowCredentials(false).maxAge(3600);
	}
}
