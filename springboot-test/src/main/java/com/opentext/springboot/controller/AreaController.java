package com.opentext.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opentext.springboot.domain.Area;
import com.opentext.springboot.service.AreaService;

@RestController
public class AreaController {

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "query", method = RequestMethod.GET)
	public List<Area> query(String username) {
		List<Area> list = areaService.findByusername(username);
		return list;
	}
}
