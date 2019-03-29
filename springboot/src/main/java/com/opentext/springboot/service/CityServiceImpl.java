package com.opentext.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opentext.springboot.dao.CityDao;
import com.opentext.springboot.model.City;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	@Override
	public City findCityByName(String cityName) {
		return cityDao.findByName(cityName);
	}

	@Override
	public List<City> findAllCityNames() {
		return cityDao.findAllNames();
	}

}
