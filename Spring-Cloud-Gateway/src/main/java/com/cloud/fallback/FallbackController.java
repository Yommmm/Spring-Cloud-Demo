package com.cloud.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FallbackController {

	@GetMapping("/fallback")
	public String hystrixFallBack() {
		return "服务响应超时，降级成功";
	}
	
}
