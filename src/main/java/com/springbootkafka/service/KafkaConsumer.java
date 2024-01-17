package com.springbootkafka.service;

import com.springbootkafka.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = "users",
      groupId = "group-user")
  public void consume(User data){
    log.info(String.format("Message received -> %s", data.toString()));
  }

}
