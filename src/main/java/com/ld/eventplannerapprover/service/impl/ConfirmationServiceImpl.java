package com.ld.eventplannerapprover.service.impl;

import com.ld.eventplannerapprover.dto.EventStatusDTO;
import com.ld.eventplannerapprover.dto.EventToApproveDTO;
import com.ld.eventplannerapprover.entity.ReservedEvent;
import com.ld.eventplannerapprover.enums.EventStatus;
import com.ld.eventplannerapprover.repo.ReservedEventRepository;
import com.ld.eventplannerapprover.service.ConfirmationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfirmationServiceImpl implements ConfirmationService {

    private final ReservedEventRepository reservedEventRepository;

    @Override
    public EventStatusDTO confirmEvent(EventToApproveDTO eventToApproveDTO) {
        if(isTimeIsReserved(eventToApproveDTO)) {
            log.info("Event id: " + eventToApproveDTO.id()
                    + " on date: " + eventToApproveDTO.eventDate()
                    + " is approved.");
            return new EventStatusDTO(eventToApproveDTO.id(), EventStatus.APPROVED);
        } else {
            log.info("Event id: " + eventToApproveDTO.id()
                    + " on date: " + eventToApproveDTO.eventDate()
                    + " is rejected.");
            return new EventStatusDTO(eventToApproveDTO.id(), EventStatus.REJECTED);
        }
    }

    private boolean isTimeIsReserved (EventToApproveDTO eventToApproveDTO) {
        if (reservedEventRepository.existsReservedEventByEventDate(eventToApproveDTO.eventDate())) {
            return false;
        } else {
            ReservedEvent reservedEvent = ReservedEvent.builder().eventDate(eventToApproveDTO.eventDate()).build();
            reservedEventRepository.save(reservedEvent);
            return true;
        }
    }
}
