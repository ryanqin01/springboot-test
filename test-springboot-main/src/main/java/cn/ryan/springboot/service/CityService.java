package cn.ryan.springboot.service;

import java.util.List;

import cn.ryan.springboot.model.City;

public interface CityService {

	public City findCityByName(String cityName);

	public List<City> findAllCityNames();

}
