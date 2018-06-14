package com.opentext.springboot.service;

import java.util.List;

import com.opentext.springboot.domain.City;

public interface CityService {

	City findCityByName(String cityName);

	List<City> findAllCityNames();

}
