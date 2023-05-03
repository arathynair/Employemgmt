package com.employee.management.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.employee.management.dto.EmployeeDto;
import com.employee.management.entity.EmployeeEntity;

/**
 * This is the mapper class for employee management.
 * 
 * @author arathynair
 *
 */
@Component
public class EmployeeMapper {

	private static final Logger log = LoggerFactory.getLogger(EmployeeMapper.class);

	/**
	 * Method for map the employeeDto to employeeEntity.
	 * 
	 * @param employeeDto
	 * @return EmployeeEntity
	 */
	public EmployeeEntity mapEmployeeEntity(EmployeeDto employeeDto) {
		log.info("mapEmployeeEntity method in mapper starts {} ", employeeDto);
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setName(employeeDto.getName());
		employeeEntity.setSalary(employeeDto.getSalary());
		employeeEntity.setBand(employeeDto.getBand());
		employeeEntity.setDeptName(employeeDto.getDeptName());
		employeeEntity.setExperience(employeeDto.getExperience());
		log.info("mapEmployeeEntity method in mapper ends {} ", employeeEntity);
		return employeeEntity;
	}

}
