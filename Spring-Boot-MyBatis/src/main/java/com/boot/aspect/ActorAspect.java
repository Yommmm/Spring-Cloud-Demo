package com.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around(value = "execution(** com.boot.service.AspectService.aspect(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		for(Object arg : args){
			System.out.println("arg is: " + arg);
			if("哈哈哈哈哈哈".equals(arg)) {
				Object proceed = pjp.proceed(new Object[]{arg + "Around"});
				System.out.println(proceed);
			} else {
				System.out.println("不干了");
			}
		}
	}

}
