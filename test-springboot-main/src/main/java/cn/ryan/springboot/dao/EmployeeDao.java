package cn.ryan.springboot.dao;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import cn.ryan.springboot.model.Employee;

public interface EmployeeDao extends SolrCrudRepository<Employee, Integer> {
	List<Employee> findByUsername(String username);
}
