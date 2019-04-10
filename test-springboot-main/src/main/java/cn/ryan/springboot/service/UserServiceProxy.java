package cn.ryan.springboot.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.ryan.springboot.model.User;

@FeignClient(name = "test-springboot-service", url = "localhost:8888")
public interface UserServiceProxy {

	@GetMapping("/combine/{id}")
	public User getUserById(@PathVariable String id);
}
