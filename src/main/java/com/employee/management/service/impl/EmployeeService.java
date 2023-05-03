package com.employee.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.employee.management.constant.EmployeeConstant;
import com.employee.management.dao.EmployeeDao;
import com.employee.management.dto.EmployeeDto;
import com.employee.management.dto.Error;
import com.employee.management.entity.EmployeeEntity;
import com.employee.management.exception.EmployeeManagementException;
import com.employee.management.mapper.EmployeeMapper;
import com.employee.management.service.IEmployeeService;
import com.employee.management.validator.EmployeeValidator;

/**
 * 
 * This is employee service class where all business logic is present.
 * 
 * @author arathynair
 *
 */
@Service
public class EmployeeService implements IEmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeeValidator employeeValidator;

	@Autowired
	private EmployeeMapper employeeMapper;

	/**
	 * Method to save the employee to the db.
	 */
	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {

		log.info("addEmployee method in service starts {} ", employeeDto);
		/** Validate the employee request **/
		employeeValidator.validateEmployeeRequest(employeeDto);
		EmployeeDto response = new EmployeeDto();
		EmployeeEntity employeeEntity = employeeMapper.mapEmployeeEntity(employeeDto);
		log.info("Employee entity response {}", employeeEntity);
		try {
			EmployeeEntity savedEmployeeEntity = employeeDao.save(employeeEntity);
			BeanUtils.copyProperties(savedEmployeeEntity, response);

		} catch (Exception e) {
			log.error(EmployeeConstant.UPDATION_FAILES, employeeDto, e.getMessage());
			throw new EmployeeManagementException(new Error(409, EmployeeConstant.UPDATION_FAILES),
					EmployeeConstant.UPDATION_FAILES);
		}
		log.info("addEmployee method in service ends {} ", response);
		return response;
	}

	/**
	 * Method to fetch employee by employeeId.
	 */
	@Override
	public EmployeeDto getEmployee(Integer employeeId) {
		log.info("getEmployee method in service starts {} ", employeeId);
		if (ObjectUtils.isEmpty(employeeId)) {
			log.error(EmployeeConstant.EMPLOYEE_ID_CANNOT_EMPTY, employeeId);
			throw new EmployeeManagementException(new Error(409, EmployeeConstant.EMPLOYEE_ID_CANNOT_EMPTY),
					EmployeeConstant.EMPLOYEE_ID_CANNOT_EMPTY);
		}
		EmployeeDto response = new EmployeeDto();
		Optional<EmployeeEntity> entityResponse = employeeDao.findById(employeeId);
		if (entityResponse.isPresent()) {
			BeanUtils.copyProperties(entityResponse.get(), response);
		} else {
			log.error(EmployeeConstant.NO_SUCH_EMPLOYEE_FOUND + employeeId);
			throw new EmployeeManagementException(new Error(204, EmployeeConstant.NO_SUCH_EMPLOYEE_FOUND),
					EmployeeConstant.NO_SUCH_EMPLOYEE_FOUND);
		}
		log.info("getEmployee method in service ends {} ", employeeId);
		return response;
	}

	/**
	 * Method to fetch all employee details.
	 */
	@Override
	public List<EmployeeDto> getAllEmployee() {
		log.info("getAllEmployee method in service starts ");
		List<EmployeeDto> responseList = new ArrayList<>();
		List<EmployeeEntity> employeeEntity = employeeDao.findAll();
		if (!CollectionUtils.isEmpty(employeeEntity)) {
			employeeEntity.forEach(each -> {
				EmployeeDto response = new EmployeeDto();
				BeanUtils.copyProperties(each, response);
				responseList.add(response);
			});
		} else {
			log.error(EmployeeConstant.NO_EMPLOYEE_FOUND);
			throw new EmployeeManagementException(new Error(204, EmployeeConstant.NO_EMPLOYEE_FOUND),
					EmployeeConstant.NO_EMPLOYEE_FOUND);
		}
		log.info("getAllEmployee method in service ends {} ", responseList);

		return responseList;
	}

	/**
	 * Method to delete an employee by employeeId.
	 */
	@Override
	public void deleteEmployee(Integer empId) {
		log.info("deleteEmployee method in service starts {} ", empId);

		if (ObjectUtils.isEmpty(empId)) {
			throw new EmployeeManagementException(new Error(409, EmployeeConstant.EMPLOYEE_ID_CANNOT_EMPTY),
					EmployeeConstant.EMPLOYEE_ID_CANNOT_EMPTY);
		}
		try {
			employeeDao.deleteById(empId);
			log.info("deleteEmployee method in service ends successfully  {} ", empId);
		} catch (Exception e) {
			log.error(EmployeeConstant.UPDATION_FAILES + empId + e.getMessage());
			throw new EmployeeManagementException(new Error(409, EmployeeConstant.DELETION_FAILS),
					EmployeeConstant.DELETION_FAILS);
		}

	}
}
