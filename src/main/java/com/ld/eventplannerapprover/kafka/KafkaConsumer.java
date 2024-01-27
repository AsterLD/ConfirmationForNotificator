package com.ld.eventplannerapprover.kafka;

import com.ld.eventplannerapprover.dto.EventToApproveDTO;
import com.ld.eventplannerapprover.service.ConfirmationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    @Autowired
    private ConfirmationService confirmationService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @KafkaListener(topics = "event-planner-approve",
            groupId = "event-planner-listener")
    public void consume(EventToApproveDTO eventToApproveDTO) {
        log.info("Message get: " + eventToApproveDTO.id());
        kafkaProducer.sendMessage(confirmationService.confirmEvent(eventToApproveDTO));
    }
}
