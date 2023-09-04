package com.ld.eventplannerapprover.kafka;

import com.ld.eventplannerapprover.dto.EventStatusDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, EventStatusDTO> kafkaTemplate;

    public void sendMessage(EventStatusDTO event) {
        log.info("Message sent: " + event.getId());
        kafkaTemplate.send("event-planner", event);
    }

}
