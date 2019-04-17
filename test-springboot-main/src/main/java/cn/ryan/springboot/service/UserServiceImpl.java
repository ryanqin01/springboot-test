package cn.ryan.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.ryan.springboot.dao.UserDao;
import cn.ryan.springboot.model.User;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;

	@HystrixCommand(fallbackMethod = "getUserFallback")
	public User getUser(String id) {
		return userDao.findById(Integer.parseInt(id)).get();
	}

	public User getUserFallback(String id) {
		User user = new User(1);
		user.setName("fallbackUser");
		user.setFrom("China");
		return user;
	}

	public List<User> getUsersByFrom(String from) {
		return userDao.findByFrom(from);
	}
}
