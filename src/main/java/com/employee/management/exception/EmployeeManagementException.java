package com.employee.management.exception;

import com.employee.management.dto.Error;

/**
 * Custom exception class employee management.
 * 
 * @author arathynair
 *
 */
public class EmployeeManagementException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3521144599732615025L;

	private Error error;

	public EmployeeManagementException(String message) {
		super(message);
	}

	public EmployeeManagementException(Error error, String message) {
		super(message);
		this.error = error;
	}

	public EmployeeManagementException() {
		super();
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}
