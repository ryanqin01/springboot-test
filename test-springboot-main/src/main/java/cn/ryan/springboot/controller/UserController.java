package cn.ryan.springboot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.ryan.springboot.model.User;
import cn.ryan.springboot.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable String id) {
		User user = userService.getUser(id);
		return user;
	}

	@GetMapping("/users")
	public List<Resource<User>> getUsersByFrom(@RequestBody User user) {
		List<User> users = userService.getUsersByFrom(user.getFrom());
		List<Resource<User>> resources = new ArrayList<>();
		users.stream().forEach(u -> {
			Resource<User> resource = new Resource<User>(u);
			resource.add(linkTo(methodOn(UserController.class).getUsersByFrom(user)).withSelfRel());
			resources.add(resource);
		});
		return resources;
	}
}
