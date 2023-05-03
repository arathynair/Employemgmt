package com.employee.management.validator;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.employee.management.dto.EmployeeDto;
import com.employee.management.dto.Error;
import com.employee.management.exception.EmployeeManagementException;

/**
 * Validator class for EmployeeManagement.
 * 
 * @author arathynair
 *
 */
@Component
public class EmployeeValidator {

	private static final Logger log = LoggerFactory.getLogger(EmployeeValidator.class);

	/**
	 * Method to validate the employee request.
	 * 
	 * @param employeee
	 */
	public void validateEmployeeRequest(EmployeeDto employeee) {

		log.info("validateEmployeeRequest method in validator starts {} ", employeee);
		if (StringUtils.isEmpty(employeee.getName())) {
			log.error("Employee name cannot ne null or Empty");
			throw new EmployeeManagementException(new Error(409, "Employee name cannot ne null or Empty"),
					"Employee name cannot ne null or Empty");
		} else if (StringUtils.isEmpty(employeee.getDeptName())) {
			log.error("Employee dept name cannot ne null or Empty");
			throw new EmployeeManagementException(new Error(409, "Employee dept name cannot ne null or Empty"),
					"Employee dept name cannot ne null or Empty");
		} else if (ObjectUtils.isEmpty(employeee.getExperience())) {
			log.error("Employee experience  cannot ne null or Empty");
			throw new EmployeeManagementException(new Error(409, "Employee experience  cannot ne null or Empty"),
					"Employee experience  cannot ne null or Empty");
		}
	}
}
