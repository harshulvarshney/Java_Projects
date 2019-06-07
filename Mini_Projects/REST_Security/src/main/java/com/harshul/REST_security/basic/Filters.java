package com.harshul.REST_security.basic;

import java.util.Collections;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to register custom filters.
 * 
 * @author harshul.varshney
 */
@Configuration
public class Filters {

	@Bean
	public FilterRegistrationBean restRegistrationBean() {
		System.out.println("Setting up restRegistrationBean");
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new RestBasicAuthFilter());
		filterRegistrationBean.setUrlPatterns(Collections.singletonList("/rest/*"));
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}

}
