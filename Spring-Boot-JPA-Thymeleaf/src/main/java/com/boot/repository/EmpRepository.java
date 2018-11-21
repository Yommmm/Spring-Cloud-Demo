package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.bean.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, String> {

	Emp queryEmpByEmpId(String empId);
	
}
