package com.boot;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTool {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public boolean lock(String lockKey, String uuid) {
		if(null == redisTemplate.opsForValue().get(lockKey)) {
			redisTemplate.opsForValue().set(lockKey, uuid, 30, TimeUnit.SECONDS);
			return true;
		}
		
		return false;
	}
	
	public void unlock(String lockKey, String uuid) {
		if(null != lockKey && uuid.equals(redisTemplate.opsForValue().get(lockKey))) {
			redisTemplate.delete(lockKey);
		}
	}
	
}
