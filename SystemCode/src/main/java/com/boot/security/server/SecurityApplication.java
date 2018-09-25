package com.boot.security.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 启动类
 * 
 * @author hebh
 *
 */
@SpringBootApplication
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
