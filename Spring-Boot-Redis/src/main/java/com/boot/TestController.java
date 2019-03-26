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
	
	@Autowired
	private RedisTool redisTool;
	
	@GetMapping("/lock")
	public void lock() {
		if(null == redisTemplate.opsForValue().get(LOCK_KEY)) {
			UUID_FLAG = UUID.randomUUID().toString();
			redisTemplate.opsForValue().set("MMP_MMP_MMP_MMP_KEY", UUID_FLAG, 60, TimeUnit.SECONDS);
		}
	}
	
	@GetMapping("/unlock")
	public void unlock() {
		if(null != UUID_FLAG && UUID_FLAG.equals(redisTemplate.opsForValue().get(LOCK_KEY))) {
			redisTemplate.delete(LOCK_KEY);
			UUID_FLAG = null;
		}
	}
	
	@GetMapping("/testLockAndUnlock1")
	public String testLockAndUnlock1() {
		String validate = UUID.randomUUID().toString();
		
		if(redisTool.lock(LOCK_KEY, validate)) {
			System.out.println("testLockAndUnlock1");
			return "success";
		}
//		redisTool.unlock(LOCK_KEY, validate);
		
		return "fail";
	}
	
	@GetMapping("/testLockAndUnlock2")
	public String testLockAndUnlock2() {
		String validate = UUID.randomUUID().toString();
		
		redisTool.lock(LOCK_KEY, validate);
		System.out.println("testLockAndUnlock2");
		redisTool.unlock(LOCK_KEY, validate);
		
		return "success";
	}

}
