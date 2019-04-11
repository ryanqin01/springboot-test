package cn.ryan.springboot.assist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ryan.springboot.assist.AssistServiceProxy;
import cn.ryan.springboot.model.User;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/client")
@Slf4j
public class UserClientController {

	@Autowired
	private AssistServiceProxy proxy;

	@GetMapping("/users/{id}")
	public User changeUser(@PathVariable String id) {
		User user = proxy.getUserById(id);
		user.setName("changed" + user.getName());
		log.info(user.toString());
		return user;
	}
}
