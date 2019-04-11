package cn.ryan.springboot.assist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class AssistApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AssistApplication.class);
		springApplication.run(args);
	}

	@Bean
	public ObjectMapper ObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}
}
