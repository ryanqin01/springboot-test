package cn.ryan.springboot.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ryan.springboot.model.City;
import cn.ryan.springboot.service.CityService;

@RestController
@RequestMapping("/city")
@MapperScan("cn.ryan.springboot.dao")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping(value = "/{cityName}")
	public City findOneCity(@PathVariable("cityName") String cityName) {
		return cityService.findCityByName(cityName);
	}

	@GetMapping
	public List<City> findAllCities() {
		return cityService.findAllCityNames();
	}
}
