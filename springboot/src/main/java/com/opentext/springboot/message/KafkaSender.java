package com.opentext.springboot.message;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opentext.springboot.model.Message;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaSender {

	@Autowired
	private String kafkaTopicName;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private Gson gson = new GsonBuilder().create();

	public void send() {
		Message message = new Message();
		message.setId(System.currentTimeMillis());
		message.setMsg(UUID.randomUUID().toString());
		message.setSendTime(new Date());
		log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
		kafkaTemplate.send(kafkaTopicName, gson.toJson(message));
	}
}
