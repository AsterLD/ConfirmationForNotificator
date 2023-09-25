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
            log.info("Event id: " + eventToApproveDTO.getId()
                    + " on date: " + eventToApproveDTO.getEventDate()
                    + " is approved.");
            return new EventStatusDTO(eventToApproveDTO.getId(), EventStatus.APPROVED);
        } else {
            log.info("Event id: " + eventToApproveDTO.getId()
                    + " on date: " + eventToApproveDTO.getEventDate()
                    + " is rejected.");
            return new EventStatusDTO(eventToApproveDTO.getId(), EventStatus.REJECTED);
        }
    }

    private boolean isTimeIsReserved (EventToApproveDTO eventToApproveDTO) {
        if (reservedEventRepository.existsReservedEventByEventDate(eventToApproveDTO.getEventDate())) {
            return false;
        } else {
            ReservedEvent reservedEvent = ReservedEvent.builder().eventDate(eventToApproveDTO.getEventDate()).build();
            reservedEventRepository.save(reservedEvent);
            return true;
        }
    }
}
