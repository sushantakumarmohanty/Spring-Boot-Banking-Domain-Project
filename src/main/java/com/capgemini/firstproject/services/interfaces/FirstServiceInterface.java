package com.capgemini.firstproject.services.interfaces;

import java.util.List;

import com.capgemini.firstproject.entity.Employee;

public interface FirstServiceInterface {

	public List<Employee> getAllEmployees();

	public Employee getEmployeedById(int ID);

	public Employee addOrUpdateEmployees(Employee employee);

	public Employee deleteUser(int ID) throws Exception;
  
}
