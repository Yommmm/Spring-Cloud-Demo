package com.boot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("spring-boot-jpa")
public interface JpaRemote {

	@GetMapping("/boot/v2/feign/pathId/{id}")
	@ResponseBody
	public Object getPath(@PathVariable("id") String id);
	
}
