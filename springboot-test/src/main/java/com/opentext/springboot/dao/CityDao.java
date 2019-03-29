package com.opentext.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.opentext.springboot.model.City;

@Mapper
public interface CityDao {

	City findByName(@Param("cityName") String cityName);

	List<City> findAllNames();
}
