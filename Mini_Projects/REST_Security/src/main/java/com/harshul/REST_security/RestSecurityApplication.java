package com.harshul.REST_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * URI: http://localhost:8080/rest/demo
 * Add header field: Authorization
 * User credentials: admin/admin
 * 
 * @author harshul.varshney
 *
 */
@SpringBootApplication
public class RestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSecurityApplication.class, args);
	}
}
