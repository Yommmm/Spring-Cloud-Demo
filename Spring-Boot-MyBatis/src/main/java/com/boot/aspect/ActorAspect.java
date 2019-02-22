package com.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.service.EmpService;

@Aspect
@Component
public class ActorAspect {
	
	@Autowired
	private EmpService empService;

	@Before("execution(** com.boot.service.AspectService.aspect(..))")
	public void before1() {
		System.out.println("化妆！");
	}
	
	@Before("execution(** com.boot.service.AspectService.aspect(..))")
	public void before2() {
		System.out.println("上台！");
	}
	
	@After(value = "execution(** com.boot.service.AspectService.aspect(..))")
	public void after() {
		System.out.println("致谢！");
	}
	
	@AfterReturning(value = "execution(** com.boot.service.AspectService.aspect(..))", returning = "result")
	public void afterReturning(JoinPoint jp, String result) {
		System.out.println(result + "！鼓掌！");
	}
	
	@AfterThrowing("execution(** com.boot.service.AspectService.aspect(..))")
	public void afterThrowing() {
		System.out.println("舞台炸了！");
	}

}
