package com.bway.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.web.model.Employee;
import com.bway.web.service.DepartmentService;
import com.bway.web.service.EmployeeService;



@Controller
public class EmployeeController {

	@Autowired private  EmployeeService emp;
	@Autowired private DepartmentService dep;
	
	@GetMapping ("/employee")
	public String getEmployee(Model model ) {
		model.addAttribute("dlist", dep.getAllDepts());
	return "addemployee";
	}
	
	@PostMapping("/employee")
	public String postEmployss(@ModelAttribute Employee empp) {
		emp.addEmp(empp);
		
		return "addemployee";
	}
	
	@GetMapping("/employeelist")
	public String getList(Model model ) {
		
		model.addAttribute("emplist", emp.getAllEmps());
		return "employee";
	}
	
	@GetMapping("/emp/edit")
	public String edit(@RequestParam long id, Model model) {
		model.addAttribute("emodel", emp.getEmpById(id));
		model.addAttribute("dlist", dep.getAllDepts());
	return "EmployeeEdit";	
	}
	
	@PostMapping("/emp/update")
	public String update(@ModelAttribute Employee empp) {
		emp.updateEmp(empp);
		return "redirect:/employeelist";
	}
	
	
	@GetMapping("/emp/delete")
	public String delete(@RequestParam Long id ) {
		emp.deleteEmp(id);
		return "redirect:/employeelist";
	}
	
	
	
	
	
	
	
	
	
	
}
