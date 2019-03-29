package com.opentext.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.opentext.springboot.message.KafkaSender;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Autowired
	KafkaSender sender;

	@Override
	public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
		for (int i = 0; i < 3; i++) {
			try {
				sender.send();
			} catch (Exception e) {
				log.warn("Kafka service is not available.");
				break;
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
