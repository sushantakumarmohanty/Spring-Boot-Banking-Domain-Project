package com.capgemini.firstproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.firstproject.entity.Employee;
import com.capgemini.firstproject.services.interfaces.FirstServiceInterface;

@RestController
public class FirstController {

	@Autowired
	FirstServiceInterface fsInterface;

// creating a get mapping that retrieves all the employees from the database
	@GetMapping("/employeeList")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> employees = null;
		try {
			employees = fsInterface.getAllEmployees();
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
 // TODO I can handle bad request status code
	@GetMapping("/employeeList/{ID}")
	public ResponseEntity<Employee> getEmployeedById(@PathVariable("ID") int ID) {
		Employee employeeData = null;
		try {
			employeeData = fsInterface.getEmployeedById(ID);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Employee>(employeeData, HttpStatus.OK);
	}
	@PostMapping("/addOrUpdate")
	public ResponseEntity<Employee> addOrUpdateEmployees(@RequestBody Employee employee) {
		Employee empData = null;
		try {
			empData = fsInterface.addOrUpdateEmployees(employee);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Employee>(empData, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{ID}")
	public ResponseEntity<Employee> deleteUser(@PathVariable("ID") int ID) {
		Employee deleteEmp = null;
		try {
			deleteEmp = fsInterface.deleteUser(ID);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Employee>(deleteEmp, HttpStatus.OK);
	}
	//TODO PutMapping 

}
