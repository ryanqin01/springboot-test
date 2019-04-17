package cn.ryan.springboot.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.ryan.springboot.message.KafkaSender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaServiceImpl {

	@Autowired
	KafkaSender sender;

	@PostConstruct
	private void sendTest() throws JsonProcessingException {
		sender.send();
		log.info("send message through kafka successfully!");
	}

	@Scheduled(fixedRate = 20000)
	void sendContinuously() throws JsonProcessingException {
		sender.send();
	}
}
