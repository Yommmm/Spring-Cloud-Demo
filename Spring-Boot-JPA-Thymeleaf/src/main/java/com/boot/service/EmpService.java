package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bean.EmpBean;
import com.boot.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository empRepository;

	public EmpBean save(EmpBean emp) {
		return empRepository.save(emp);
	}
	
	public EmpBean update(EmpBean emp) {
		return empRepository.saveAndFlush(emp);
	}
	
	public EmpBean delete(String empId) {
		EmpBean empBean = this.query(empId);
		empRepository.deleteById(empId);
		return empBean;
	}
	
	public List<EmpBean> list() {
		return empRepository.findAll();
	}
	
	public EmpBean query(String empId) {
		return empRepository.queryEmpBeanByEmpId(empId);
	}
	
}
