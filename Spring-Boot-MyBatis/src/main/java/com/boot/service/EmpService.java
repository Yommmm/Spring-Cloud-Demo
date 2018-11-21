package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Emp;
import com.boot.mapper.EmpMapper;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	
	public List<Emp> list() {
		return empMapper.findAll();
	}
	
}
