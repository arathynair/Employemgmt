package com.employee.management.service;

import java.util.List;

import com.employee.management.dto.EmployeeDto;

/**
 * Interface for employee service calss.
 * @author arathynair
 *
 */
public interface IEmployeeService {
	
	public EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	public EmployeeDto getEmployee(Integer employeeId);
	
	public List<EmployeeDto> getAllEmployee();
	
	public void deleteEmployee(Integer empId);




}
