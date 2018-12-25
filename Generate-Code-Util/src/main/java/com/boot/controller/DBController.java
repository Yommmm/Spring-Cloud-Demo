package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.service.DBService;

@RestController
@RequestMapping("/cg/v1/db")
public class DBController {
	
	@Autowired
	private DBService dbService;

	@GetMapping("/table")
	public List<String> getTableList() {
		return dbService.getTableList();
	}
	
	@GetMapping("/table/{tableName}")
	public Object getTableInfo(@PathVariable String tableName) {
		return dbService.getTableInfo(tableName);
	}
	
}
