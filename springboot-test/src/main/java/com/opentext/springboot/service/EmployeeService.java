package com.opentext.springboot.service;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.opentext.springboot.domain.Employee;

public interface EmployeeService extends SolrCrudRepository<Employee, Integer> {
	List<Employee> findByusername(String username);
}
