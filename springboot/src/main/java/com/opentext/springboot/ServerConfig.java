package com.opentext.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "test-service")
public class ServerConfig {

	@Getter
	@Setter
	private int testvalue;

}
