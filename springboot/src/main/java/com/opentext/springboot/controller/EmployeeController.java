package com.opentext.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.springboot.dao.EmployeeDao;
import com.opentext.springboot.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping(value = "/{username}")
	public List<Employee> findEmployeeByName(@PathVariable("username") String username) {
		List<Employee> list = employeeDao.findByUsername(username);
		return list;
	}
}
