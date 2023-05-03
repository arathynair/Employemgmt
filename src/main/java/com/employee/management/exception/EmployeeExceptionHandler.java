package com.employee.management.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.management.dto.BaseResponse;
import com.employee.management.dto.Error;

/**
 * Global exception handler for handling exceptions.
 * 
 * @author arathynair
 *
 */
@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Method for handle employeemanagement exceptions.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = EmployeeManagementException.class)
	public ResponseEntity<BaseResponse> handleValidationErrors(EmployeeManagementException ex) {
		ResponseEntity<BaseResponse> response;
		BaseResponse baseresponse = new BaseResponse();
		List<Error> errors = new ArrayList<>();
		errors.add(ex.getError());
		baseresponse.setErrors(errors);
		if (ex.getError().getErrorCode().equals(204)) {
			response = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else if (ex.getError().getErrorCode().equals(409)) {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body(baseresponse);
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return response;
	}

	/**
	 * Method for handle all other exceptions.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<BaseResponse> handleAllExceptions(Exception ex) {
		ResponseEntity<BaseResponse> response;
		BaseResponse baseresponse = new BaseResponse();
		List<Error> errors = new ArrayList<>();
		errors.add(new Error(500, ex.getMessage()));
		baseresponse.setErrors(errors);
		response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseresponse);
		return response;
	}

}
