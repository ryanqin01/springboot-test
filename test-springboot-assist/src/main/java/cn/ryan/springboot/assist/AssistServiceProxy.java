package cn.ryan.springboot.assist;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.ryan.springboot.model.User;

// @FeignClient(name = "test-springboot-main-service")
@FeignClient(name = "test-springboot-gateway-service")
@RibbonClient(name = "test-springboot-main-service")
public interface AssistServiceProxy {

	// @GetMapping("/users/{id}")
	@GetMapping("test-springboot-main-service/users/{id}")
	public User getUserById(@PathVariable String id);
}
