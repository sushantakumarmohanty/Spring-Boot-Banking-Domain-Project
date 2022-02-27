package com.capgemini.firstproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.firstproject.customException.ResourceNotFoundException;
import com.capgemini.firstproject.entity.Employee;
import com.capgemini.firstproject.repository.FirstProjectRepository;
import com.capgemini.firstproject.services.interfaces.FirstServiceInterface;
import java.util.Optional;

@Service
public class FirstService implements FirstServiceInterface {

	@Autowired
	private FirstProjectRepository firstProjectRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return firstProjectRepository.findAll();
	}

	@Override
	public Employee getEmployeedById(int id) {
		// TODO Auto-generated method stub
		return firstProjectRepository.findById(id).orElse(null);
	}

	@Override
	public Employee addOrUpdateEmployees(Employee employee) {

		Optional<Employee> EmployeeDb = this.firstProjectRepository.findById(employee.getId());
		// TODO Auto-generated method stub
		if (EmployeeDb.isPresent()) {
			Employee employeeUpdate = EmployeeDb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setFirstName(employee.getFirstName());
			employeeUpdate.setLastName(employee.getLastName());
			employeeUpdate.setEmail(employee.getEmail());
			firstProjectRepository.save(employeeUpdate);
			return employeeUpdate;
		} else if (!EmployeeDb.isPresent()) {
			return firstProjectRepository.save(employee);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
		}
	}

	@Override
	public Employee deleteUser(int id) throws Exception {
		Employee deletedEMP = null;
		try {
			deletedEMP = firstProjectRepository.findById(id).orElse(null);
			if (deletedEMP == null) {
				throw new Exception("Employee is not available");
			} else {
				firstProjectRepository.deleteById(id);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return deletedEMP;
	}

}
