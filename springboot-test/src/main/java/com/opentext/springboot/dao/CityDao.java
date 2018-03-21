package com.opentext.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.opentext.springboot.domain.City;

@Mapper
public interface CityDao {

	City findByName(@Param("cityName") String cityName);
}
