package com.microservice.two.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.two.Model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByUserName(String UserName);
	Employee findByPassword(String Password);

}
