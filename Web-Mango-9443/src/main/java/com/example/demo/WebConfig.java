package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filter.XSSFilter;

@Configuration
public class WebConfig {
	
	@Bean
	public FilterRegistrationBean<XSSFilter> filterRegistrationBean() {
		FilterRegistrationBean<XSSFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new XSSFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setName("XSSFilter");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}
	
}
