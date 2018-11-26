package com.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.common.entity.Result;
import com.boot.entity.Emp;
import com.boot.feign.JpaRemote;

@RestController
@RequestMapping("/boot/v2/feign")
public class FeignController {

	private static final Logger logger = LoggerFactory.getLogger(FeignController.class);
	
	@Autowired
	private JpaRemote jpaRemote;
	
	@GetMapping
	public Result test() {
		logger.info("come on!");
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("aaaa", "aaaa");
		param.put("bbbb", "bbbb");
		param.put("cccc", "cccc");
		param.put("dddd", "dddd");
		jpaRemote.post(param);
		
		/** 都用后台调用了，还用GET方法干什么。。。
		Emp emp = new Emp();
		emp.setEmpId("abcdef");
		jpaRemote.get(emp);
		*/
		
		jpaRemote.getPath("12306");
		
		jpaRemote.getParam("12307");
		
		jpaRemote.put("12308", param);
		
		jpaRemote.delete("12309");
		
		return Result.ToResult("success");
	}
	
}
