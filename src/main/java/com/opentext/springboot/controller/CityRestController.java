package com.opentext.springboot.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.springboot.model.City;
import com.opentext.springboot.service.CityService;

@RestController
@RequestMapping("/city")
@MapperScan("com.opentext.springboot.dao")
public class CityRestController {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
	public City findOneCity(@PathVariable("cityName") String cityName) {
		return cityService.findCityByName(cityName);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<City> findAllCities() {
		return cityService.findAllCityNames();
	}
}
