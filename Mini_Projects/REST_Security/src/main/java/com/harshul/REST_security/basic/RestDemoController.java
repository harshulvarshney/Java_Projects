package com.harshul.REST_security.basic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample controler to show that any incoming request will come to auth filter first .
 * @author harshul.varshney
 */
@RestController
@RequestMapping(value = "/rest")
public class RestDemoController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/demo")
	public ResponseEntity<String> getResourse() {
		return ResponseEntity.ok("Successfully logged-in");
	}
	
}
