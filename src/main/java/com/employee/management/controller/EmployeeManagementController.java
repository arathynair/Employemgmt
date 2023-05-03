package com.employee.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.dto.EmployeeDto;
import com.employee.management.service.impl.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * This is controller class for employee end points
 * 
 * @author arathynair
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeManagementController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger log = LoggerFactory.getLogger(EmployeeManagementController.class);

	/**
	 * End-point for add/update an employee.
	 * 
	 * @return ResponseEntity
	 */
	@PostMapping
	@Operation(summary = " Add/Update employee details", description = "Api for adding or updating employees")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto newEmployee) {

		log.info("addeEmployee method in controller starts with request {}", newEmployee);
		EmployeeDto response = employeeService.addEmployee(newEmployee);
		log.info("addeEmployee method ends with response {}", response);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	/**
	 * This is the endpoint for search an employee by employeeId.
	 * 
	 * @param empId
	 * @return ResponseEntity
	 */
	@GetMapping("/details/{empId}")
	@Operation(summary = " Search employee details by empId", description = "Api for searching an employee by empId")
	public ResponseEntity<?> getEmployee(@PathVariable Integer empId) {

		log.info("getEmployee method in controller starts with empId {}", empId);
		EmployeeDto response = employeeService.getEmployee(empId);
		log.info("getEmployee method in controller method ends with response {}", response);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	/**
	 * This is the endpoint for fetch all employees in the database.
	 * 
	 * @return ResponseEntity
	 */
	@GetMapping("/getemployees")
	@Operation(summary = " Search employee details", description = "Api for searching an employee")
	public ResponseEntity<?> getAllEmployee() {
		log.info("getAllEmployee method in controller starts ");
		List<EmployeeDto> response = employeeService.getAllEmployee();
		log.info("getAllEmployee method in controller method ends with response {}", response);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	/**
	 * This is the endpoint for delete an employee by employee Id.
	 * 
	 * @param empId
	 * @return ResponseEntity
	 */
	@DeleteMapping("delete/{empId}")
	@Operation(summary = " Delete an  employee ", description = "Api for delete  an employee by employee Id.")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer empId) {
		log.info("deleteEmployee method in controller starts with empId{}", empId);
		employeeService.deleteEmployee(empId);
		log.info("deleteEmployee method in controller method ends");
		return ResponseEntity.status(HttpStatus.OK).body("Deletion successfull");

	}

}
