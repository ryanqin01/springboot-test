package cn.ryan.springboot.assist;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.ryan.springboot.model.User;

@FeignClient(name = "test-springboot-main-service", url = "localhost:8888")
public interface AssistServiceProxy {

	@GetMapping("/users/{id}")
	public Resource<User> getUserById(@PathVariable int id);
}
