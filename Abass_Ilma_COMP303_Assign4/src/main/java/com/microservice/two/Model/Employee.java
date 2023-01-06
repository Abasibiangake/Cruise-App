package com.microservice.two.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="employee" ) //, uniqueConstraints= @UniqueConstraint(columnNames="EmpId"))
public class Employee {
	@Id
	@Column(name="empId", unique=true)
	private int empId;
	@Column(name="empName")
	private String empName;	
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(int empId, String empName, String userName, String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.userName = userName;
		this.password = password;
	}



	public int getEmpId() {
		return empId;
	}



	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", userName=" + userName + ", password=" + password
				+ "]";
	}

	


}