package com.spring.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.entity.Employee;
import com.spring.example.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class SearchRestController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = employeeService.getEmployee(id);
		if(employee == null) {
			throw new SearchNotFoundException("ID not found - " + id);
		}
		return employee;
	}
	
	//REST client to send "Content-type: application/json" in HTTP request header 
	//Json to add employee, exclude id - {"firstName":"Test", "lastName":"Ali", "email":"abc@gmail.com"}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		//set as 0 or null, referring to null or empty, insert instead of update
		employee.setId(0);
		employeeService.saveEmployee(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateCusotmer(@RequestBody Employee employee) {
		//id to include as part of request body, 
		employeeService.saveEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee tempData = employeeService.getEmployee(id);
		if (tempData == null ) {
			throw new SearchNotFoundException("Item with id not found - " + id);
		}
		
		employeeService.deleteEmployee(id);
		return "Deleted item with id - " + id;
	}
	
}
