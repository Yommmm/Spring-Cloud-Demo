package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bean.Emp;
import com.boot.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository empRepository;

	public Emp save(Emp emp) {
		return empRepository.save(emp);
	}
	
	public Emp update(Emp emp) {
		return empRepository.saveAndFlush(emp);
	}
	
	public Emp delete(String empId) {
		Emp Emp = this.query(empId);
		empRepository.deleteById(empId);
		return Emp;
	}
	
	public List<Emp> list() {
		return empRepository.findAll();
	}
	
	public Emp query(String empId) {
		return empRepository.queryEmpByEmpId(empId);
	}
	
}
