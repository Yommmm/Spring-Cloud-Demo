package com.cloud.config.filter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.cloud.constants.ExceptionConstants;
import com.cloud.constants.GlobalConstants;

import reactor.core.publisher.Mono;

@Component
public class AuthorizationFilter implements GlobalFilter, Ordered {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		String token = this.getToken(request);
		
		if(this.validate(token)) {
			/**
			 * TODO 
			 * 刷新Redis中 token 过期时间
			 */
			return chain.filter(exchange);
		} else {
			throw new RuntimeException(ExceptionConstants.TOKEN_ILLEGAL_OR_EXPIRED);
		}
		
	}
	
	private boolean validate(String token) {
		/**
		 * TODO
		 * 用户登录时，通过认证后将 token 放入Redis，并设置过期时间
		 */
		if("666".equals(token)) {
			return true;
		}
		
		return false;
	}
	
	private String getToken(ServerHttpRequest request) {
		List<String> tokens = request.getHeaders().get(GlobalConstants.ACCESS_TOKEN);
		
		if(null == tokens || tokens.isEmpty()) {
			tokens = request.getQueryParams().get(GlobalConstants.ACCESS_TOKEN);
		}
		
		if(null == tokens || tokens.isEmpty()) {
			throw new RuntimeException(ExceptionConstants.TOKEN_IS_NULL);
		} 
		
		logger.debug("tokens are {}", tokens);
		return tokens.get(0);
	}

}
