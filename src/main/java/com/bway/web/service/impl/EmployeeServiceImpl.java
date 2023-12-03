package com.bway.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.web.model.Employee;
import com.bway.web.repository.EmployeeRepository;
import com.bway.web.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public void addEmp(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public void deleteEmp(Long id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public Employee getEmpById(Long id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmps() {
		
		return empRepo.findAll();
	}
	
	

}
