package com.opentext.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

	@Value("${spring.kafka.topic}")
	private String topic;

	@Bean
	public String kafkaTopicName() {
		return topic;
	}

}
