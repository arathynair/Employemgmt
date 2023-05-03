package com.employee.management.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends BaseResponse{
	
	private Integer employeeId;
	@NotNull(message ="Name cannot be null or empty")
	private String name;
	private String deptName;
	private Double salary;
	private String band;
	private Double experience;
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(Integer employeeId, @NotNull String name, String deptName, Double salary, String band,
			Double experience) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.deptName = deptName;
		this.salary = salary;
		this.band = band;
		this.experience = experience;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public Double getExperience() {
		return experience;
	}
	public void setExperience(Double experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", name=" + name + ", deptName=" + deptName + ", salary="
				+ salary + ", band=" + band + ", experience=" + experience + "]";
	}


}
