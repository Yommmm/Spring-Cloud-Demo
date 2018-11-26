package com.boot.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.entity.Emp;

@FeignClient("spring-boot-jpa")
public interface JpaRemote {

	
	@GetMapping("/boot/v2/feign/singleParam")
	public String post(@RequestBody Map<String, String> param);
	
	@GetMapping("/boot/v2/feign")
	public String get(Emp emp);
	
	@GetMapping("/boot/v2/feign/pathId/{id}")
	public String getPath(@PathVariable("id") String id);

	@GetMapping("/boot/v2/feign/paramId")
	public String getParam(@RequestParam("id") String id);
	
	@PutMapping("/boot/v2/feign/{id}")
	public String put(@PathVariable("id") String id, @RequestBody Map<String, String> param);
	
	@DeleteMapping("/boot/v2/feign/{id}")
	public String delete(@PathVariable("id") String id);
	
}
