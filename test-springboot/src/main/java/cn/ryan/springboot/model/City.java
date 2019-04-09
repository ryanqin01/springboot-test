package cn.ryan.springboot.model;

import lombok.Getter;
import lombok.Setter;

public class City {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private Long provinceId;

	@Getter
	@Setter
	private String cityName;

	@Getter
	@Setter
	private String description;
}
