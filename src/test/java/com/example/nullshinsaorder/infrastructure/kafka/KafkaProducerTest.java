package com.example.nullshinsaorder.infrastructure.kafka;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("local")
class KafkaProducerTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
//    @Disabled
    void name() {
        String testMsg = "test Message4 ~~  ";

        kafkaProducer.sendMessage(testMsg);
    }
}