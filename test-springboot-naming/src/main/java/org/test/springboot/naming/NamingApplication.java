package org.test.springboot.naming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(NamingApplication.class);
		springApplication.run(args);
	}
}
