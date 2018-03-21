package com.opentext.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opentext.springboot.dao.CityDao;
import com.opentext.springboot.domain.City;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	public City findCityByName(String cityName) {
		return cityDao.findByName(cityName);
	}

}
