package com.boot.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Emp;
import com.boot.mapper.EmpMapper;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	
	public List<Emp> list() {
		return empMapper.list();
	}
	
	public Emp getOne(String empId) {
		return empMapper.getOne(empId);
	}
	
	public Emp save(Emp emp) {
		emp.setEmpId(UUID.randomUUID().toString().replace("-", ""));
		empMapper.insert(emp);
		return emp;
	}
	
	public Emp update(Emp emp) {
		empMapper.update(emp);
		return emp;
	}
	
	public String delete(String empId) {
		empMapper.delete(empId);
		return empId;
	}
	
}
