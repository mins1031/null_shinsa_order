package com.example.nullshinsaorder.infrastructure.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic-name.order-save}")
    public String topicName;

    public void sendMessage(String message) {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, message);

        kafkaTemplate.send(producerRecord);
        kafkaTemplate.flush();
    }
}
