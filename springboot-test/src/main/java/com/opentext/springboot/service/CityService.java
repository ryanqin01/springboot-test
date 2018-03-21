package com.opentext.springboot.service;

import com.opentext.springboot.domain.City;

public interface CityService {

	City findCityByName(String cityName);
}
