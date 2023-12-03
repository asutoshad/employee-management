package com.bway.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.web.model.Department;
import com.bway.web.service.DepartmentService;

@Controller 
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping ("/department")
	public String getDepartment() {
	return "Department";
	}
	
	@PostMapping("/department")
	public String postDepartment(@ModelAttribute Department dept) {
		deptService.addDept(dept);
		return "Department";
	}
	
	@GetMapping("/deptlist")
	public String getList(Model model ) {
		model.addAttribute("dlist", deptService.getAllDepts());
		return "Departmentlist";
	}
	
	@GetMapping("/dept/delete")
	public String delete(@RequestParam int id) {
		deptService.deleteDept(id);
		return "redirect:/deptlist"; 
	}
	
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("dptmodel", deptService.getById(id));
		return "DepartmentEditForm";
	}
	
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		deptService.updateDept(dept);
		return "redirect:/deptlist";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "Login";
	}

}
