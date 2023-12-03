
package com.bway.web.service;

import java.util.List;

import com.bway.web.model.Employee;

public interface EmployeeService {

	
	void addEmp(Employee emp);
	void deleteEmp(Long id);
	void updateEmp(Employee emp);
	Employee getEmpById(Long id);
	List<Employee> getAllEmps();
}
