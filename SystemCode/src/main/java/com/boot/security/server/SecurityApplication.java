package com.boot.security.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * 
 * @author hebh
 *
 */
@SpringBootApplication
@EnableScheduling
public class SecurityApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		//return application.sources(SecurityApplication.class);
//		return application.sources(SecurityApplication.class);
//	}
//
//	private static Class applicationClass = SecurityApplication.class;

}
