package com.ld.confirmationfornotificator.kafka;

import com.ld.confirmationfornotificator.dto.EventToApproveDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "notificator",
            groupId = "notificator-listener")
    public void consume(EventToApproveDTO eventToApproveDTO) {
        log.info("Message get: " + eventToApproveDTO.getId());
    }
}
