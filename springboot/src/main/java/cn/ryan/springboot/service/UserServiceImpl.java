package cn.ryan.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ryan.springboot.dao.UserDao;
import cn.ryan.springboot.model.User;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;

	public User getUser(int id) {
		return userDao.findById(id).get();
	}
}
