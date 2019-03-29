package com.opentext.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.springboot.model.Employee;
import com.opentext.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService areaService;

	@RequestMapping(value = "query", method = RequestMethod.GET)
	public List<Employee> query(String username) {
		List<Employee> list = areaService.findByusername(username);
		return list;
	}
}
