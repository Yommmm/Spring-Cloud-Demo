package com.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zuul.filter.TokenFilter;

@Configuration
public class ZuulConfig {

	@Bean
	public TokenFilter tokenFilter() {
		return new TokenFilter();
	}
	
}
