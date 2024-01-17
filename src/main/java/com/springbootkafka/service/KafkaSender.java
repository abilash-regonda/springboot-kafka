package com.springbootkafka.service;

import com.springbootkafka.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaSender {

  private final KafkaTemplate<String, User> kafkaTemplate;

  private String kafkaTopic = "users";

  public void send(User user) {
    Message<User> message = MessageBuilder
        .withPayload(user)
        .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
        .build();
    kafkaTemplate.send(message);
  }

}
