package com.cloud.config;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class AuthorizationFilter implements GlobalFilter, Ordered {

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		extractHeaderToken(request);
		
		
		return chain.filter(exchange);
		
	}
	
	private String extractHeaderToken(ServerHttpRequest request) {
		List<String> list = request.getQueryParams().get("token");
		System.out.println(list);
		List<String> list2 = request.getHeaders().get("token");
		System.out.println(list2);
		
		return null;
	}

}
