package com.microservice.two.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microservice.two.Model.Employee;
import com.microservice.two.Repository.EmployeeRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class EmployeeController  implements ErrorController {

	@Autowired
	EmployeeRepository employeeRepo;

	@RequestMapping("/")
	public String home(Model model) {
		return "index";
		}

	@RequestMapping("/registration")
	public String register() {
		return "register";
		}
	
	
	@RequestMapping("/error") 
	public String errorMessage() {
		return "404"; 
		}
	 

	@PostMapping("/register")
	public @ResponseBody String addEmployee(
			@RequestParam("empId") int empId, 
			@RequestParam("empName") String empName,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		Employee employee = new Employee(empId, empName, userName, password);
		employeeRepo.save(employee);
		return "A new employee is added";
	}

	@RequestMapping("/home")
	public String employeeRegister(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		Iterable<Employee> iterator = employeeRepo.findAll();
        iterator.forEach(item -> System.out.println(item));

		System.out.println(employeeRepo.findByUserName(username));
		Employee loginEmp = employeeRepo.findByUserName(username);
		System.out.println(loginEmp.getPassword());
		if (username.equals(loginEmp.getUserName()) && password.equals((loginEmp.getPassword()))) {
			model.addAttribute("userName", loginEmp.getUserName());
			return "home";
		} else {
			return "404";
		}
	}
}
