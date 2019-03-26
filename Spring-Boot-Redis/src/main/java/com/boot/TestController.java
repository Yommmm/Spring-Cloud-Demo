package com.boot;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
	
	private static final String LOCK_KEY = "LOCK_KEY";
	
	private String UUID_FLAG = null;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@GetMapping("/lock")
	public void lock() {
		if(null == UUID_FLAG && null == redisTemplate.opsForValue().get(LOCK_KEY)) {
			UUID_FLAG = UUID.randomUUID().toString();
			redisTemplate.opsForValue().set(LOCK_KEY, UUID_FLAG, 60, TimeUnit.SECONDS);
		}
	}
	
	@GetMapping("/unlock")
	public void unlock() {
		if(null != UUID_FLAG && UUID_FLAG.equals(redisTemplate.opsForValue().get(LOCK_KEY))) {
			redisTemplate.delete(LOCK_KEY);
			UUID_FLAG = null;
		}
	}

}
