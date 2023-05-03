package com.employee.management.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

/**
 * BaseResponse class for error handling.
 * @author arathynair
 * 
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4389578034990742195L;
	@ApiModelProperty(hidden = true)
	private List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	
}
