package com.ld.confirmationfornotificator.kafka;

import com.ld.confirmationfornotificator.dto.EventStatusDTO;
import com.ld.confirmationfornotificator.dto.EventToApproveDTO;
import com.ld.confirmationfornotificator.enums.EventStatus;
import com.ld.confirmationfornotificator.service.ConfirmationService;
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

    @KafkaListener(topics = "notificator-approve",
            groupId = "notificator-listener")
    public void consume(EventToApproveDTO eventToApproveDTO) {
        log.info("Message get: " + eventToApproveDTO.getId());
        kafkaProducer.sendMessage(confirmationService.confirmEvent(eventToApproveDTO));
    }
}
