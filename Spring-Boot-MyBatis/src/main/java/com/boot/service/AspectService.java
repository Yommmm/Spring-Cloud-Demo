package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AspectService {
	
	@Autowired
	private EmpService empService;
	
	@Transactional
	public String aspect(String actor) {
		
		if("哈哈哈哈哈哈".equals(actor)) {
			System.out.println("表演台用力！");
			throw new RuntimeException("表演台用力！");
		}
		System.out.println(actor + "开始表演！");
		return actor + "表演完成";
	}

}
