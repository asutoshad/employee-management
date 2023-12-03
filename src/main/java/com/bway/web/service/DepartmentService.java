package com.bway.web.service;

import java.util.List;

import com.bway.web.model.Department;

public interface DepartmentService {

	void addDept(Department dept);

	void deleteDept(int id);

	void updateDept(Department dept);

	Department getById(int id);

	List<Department> getAllDepts();
}
