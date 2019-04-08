package com.opentext.springboot.service;

import java.util.List;

import com.opentext.springboot.model.City;

public interface CityService {

	public City findCityByName(String cityName);

	public List<City> findAllCityNames();

}
