package com.springbootkafka.controller;

import com.springbootkafka.dto.User;
import com.springbootkafka.service.KafkaSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaWebController {

  private final KafkaSender kafkaSender;

  @GetMapping(value = "/kafka/producer")
  public String producer(@RequestBody User user) {
    kafkaSender.send(user);
    return "Message sent to the Kafka Topic java_in_use_topic Successfully";
  }

}
