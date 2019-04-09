package com.opentext.springboot.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.opentext.springboot.message.KafkaSender;

@Service
public class KafkaServiceImpl {

	@Autowired
	KafkaSender sender;

	@PostConstruct
	private void sendTest() {
		sender.send();
	}

	@Scheduled(fixedRate = 2000)
	private void sendContinuously() {
		sender.send();
	}
}
