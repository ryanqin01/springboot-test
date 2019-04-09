package com.opentext.springboot.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Data;

@SolrDocument(collection = "testCollection")
@Data
public class Employee {

	@Id
	@Field
	private int id;

	@Field
	private String username;

	@Field
	private String manager;

}
