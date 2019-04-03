package com.opentext.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "About user")
@Entity
public class User {

	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Integer id;

	@Size(min = 2)
	@ApiModelProperty(notes = "Name should have min 2 characters")
	@Getter
	@Setter
	private String name;
}
