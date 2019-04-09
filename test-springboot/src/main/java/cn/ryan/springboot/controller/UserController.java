package cn.ryan.springboot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.ryan.springboot.model.User;
import cn.ryan.springboot.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		User user = userService.getUser(id);
		Resource<User> resource = new Resource<User>(user);
		resource.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
		return resource;
	}
}
