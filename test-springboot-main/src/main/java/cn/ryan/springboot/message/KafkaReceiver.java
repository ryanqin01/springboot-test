package cn.ryan.springboot.message;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaReceiver {

	@KafkaListener(topics = "#{kafkaTopicName}")
	public void listen(ConsumerRecord<?, ?> record) {
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			log.debug("consumer record = {}", record);
			log.debug("receive message = {}", message);
		}
	}
}
