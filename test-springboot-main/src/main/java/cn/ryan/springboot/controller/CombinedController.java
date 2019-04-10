package cn.ryan.springboot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.ryan.springboot.model.User;
import cn.ryan.springboot.service.UserServiceProxy;

@RestController
@RequestMapping("/combine")
public class CombinedController {

	@Autowired
	private UserServiceProxy proxy;

	@GetMapping
	public List<Resource<String>> getUserAndClock() {
		List<Resource<String>> resources = new ArrayList<>();

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", "1");
		User user = new RestTemplate().getForEntity("http://localhost:8888/users/{id}", User.class, uriVariables).getBody();
		Resource<String> resource1 = new Resource<String>(user.toString());
		resource1.add(linkTo(methodOn(CombinedController.class).getUserAndClock()).withSelfRel());
		resources.add(resource1);

		String clock = new RestTemplate().getForEntity("http://localhost:8888/clock", String.class, uriVariables).getBody();
		Resource<String> resource2 = new Resource<String>(clock);
		resource2.add(linkTo(methodOn(CombinedController.class).getUserAndClock()).withSelfRel());
		resources.add(resource2);

		return resources;
	}

	@GetMapping("/{id}")
	public Resource<User> getUserById(@PathVariable("id") String id) {
		User user = proxy.getUserById(id);
		Resource<User> resource = new Resource<User>(user);
		return resource;
	}
}
