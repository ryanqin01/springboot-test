package com.opentext.springboot.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.springboot.domain.City;
import com.opentext.springboot.service.CityService;

@RestController
@MapperScan("com.opentext.springboot.dao")
public class CityRestController {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
		return cityService.findCityByName(cityName);
	}

}
