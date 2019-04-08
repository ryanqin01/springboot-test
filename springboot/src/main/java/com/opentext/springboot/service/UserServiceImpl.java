package com.opentext.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opentext.springboot.dao.UserDao;
import com.opentext.springboot.model.User;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;

	public User getUser(int id) {
		return userDao.getOne(id);
	}
}
