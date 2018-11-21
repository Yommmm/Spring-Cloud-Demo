package com.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bean.Emp;
import com.boot.bean.common.entity.Result;
import com.boot.service.EmpService;

@RestController
@RequestMapping("/boot/v2/emp")
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService empService;
	
	@PostMapping
	public Result save(@RequestBody Emp emp) {
		logger.info(emp.toString());
		return Result.ToResult(empService.save(emp));
	}
	
	@PutMapping
	public Result update(@RequestBody Emp emp) {
		logger.info(emp.toString());
		return Result.ToResult(empService.update(emp));
	}
	
	@DeleteMapping("/{empId}")
	public Result delete(@PathVariable String empId) {
		logger.info(empId);
		return Result.ToResult(empService.delete(empId));
	}
	
	@GetMapping("/{empId}")
	public Result query(@PathVariable String empId) {
		logger.info(empId);
		return Result.ToResult(empService.query(empId));
	}
	
	@GetMapping("/list")
	public Result list() {
		logger.info("list");
		return Result.ToResult(empService.list());
	}
	
}
