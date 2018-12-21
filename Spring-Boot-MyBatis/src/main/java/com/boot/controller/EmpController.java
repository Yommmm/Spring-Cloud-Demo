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

import com.boot.common.entity.Result;
import com.boot.entity.Emp;
import com.boot.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "员工API")
@RestController
@RequestMapping("/boot/v2/emp")
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService empService;
	
	@PostMapping
	@ApiOperation(value = "新增", notes="新增员工API", produces = "application/json")
	@ApiImplicitParam(name = "emp", value = "创建", dataType = "Emp", required = true)
	public Result save(@RequestBody Emp emp) {
		logger.info(emp.toString());
		return Result.ToResult(empService.save(emp));
	}
	
	@PutMapping
	@ApiOperation(value = "更新", notes="更新员工API", produces = "application/json")
	@ApiImplicitParam(name = "emp", value = "用户", dataType = "Emp", paramType = "body")
	public Result update(@RequestBody Emp emp) {
		logger.info(emp.toString());
		return Result.ToResult(empService.update(emp));
	}
	
	@DeleteMapping("/{empId}")
	@ApiOperation(value = "删除", notes="删除员工API", produces = "application/json")
	@ApiImplicitParam(name = "empId", value = "用户ID", dataType = "String", paramType = "path")
	public Result delete(@PathVariable String empId) {
		logger.info(empId);
		return Result.ToResult(empService.delete(empId));
	}
	
	@GetMapping("/{empId}")
	@ApiOperation(value = "查询", notes="查询员工API", produces = "application/json")
	@ApiImplicitParam(name = "empId", value = "用户ID", dataType = "String", paramType = "path")
	public Result query(@PathVariable String empId) {
		logger.info(empId);
		return Result.ToResult(empService.getOne(empId));
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "列表", notes="员工列表API", produces = "application/json")
	public Result list() {
		logger.info("list");
		return Result.ToResult(empService.list());
	}
	
	@GetMapping("/stock")
	public Object getStock() {
		return empService.getStock();
	}
	
}
