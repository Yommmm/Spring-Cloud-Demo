package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.bean.EmpBean;

@Repository
public interface EmpRepository extends JpaRepository<EmpBean, String> {

	EmpBean queryEmpBeanByEmpId(String empId);
	
}
