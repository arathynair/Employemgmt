package com.employee.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.entity.EmployeeEntity;

/**
 * This is the employee interface for employee management.
 * @author arathynair
 *
 */
@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{
	
	
	

}
