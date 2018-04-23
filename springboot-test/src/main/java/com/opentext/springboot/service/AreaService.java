package com.opentext.springboot.service;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.opentext.springboot.domain.Area;

public interface AreaService extends SolrCrudRepository<Area, Integer> {
	List<Area> findByusername(String username);
}
