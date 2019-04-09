package com.opentext.springboot.message;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opentext.springboot.model.Message;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaSender {

	@Autowired
	private String kafkaTopicName;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ObjectMapper objectMapper;

	public void send() throws JsonProcessingException {
		Message message = new Message();
		message.setId(System.currentTimeMillis());
		message.setMsg(UUID.randomUUID().toString());
		message.setSendTime(new Date());
		log.info("send message = {}", objectMapper.writeValueAsString(message));
		kafkaTemplate.send(kafkaTopicName, objectMapper.writeValueAsString(message));
	}
}
