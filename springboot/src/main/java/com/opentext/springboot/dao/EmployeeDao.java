package com.opentext.springboot.dao;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.opentext.springboot.model.Employee;

public interface EmployeeDao extends SolrCrudRepository<Employee, Integer> {
	List<Employee> findByUsername(String username);
}
