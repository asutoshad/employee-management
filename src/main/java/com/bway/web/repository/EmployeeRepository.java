package com.bway.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.web.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
