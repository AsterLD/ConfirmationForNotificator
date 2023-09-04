package com.ld.eventplannerapprover.service.impl;

import com.ld.eventplannerapprover.dto.EventStatusDTO;
import com.ld.eventplannerapprover.dto.EventToApproveDTO;
import com.ld.eventplannerapprover.entity.ReservedEvent;
import com.ld.eventplannerapprover.enums.EventStatus;
import com.ld.eventplannerapprover.repo.ReservedEventRepository;
import com.ld.eventplannerapprover.service.ConfirmationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ConfirmationServiceImpl implements ConfirmationService {

    private final ReservedEventRepository reservedEventRepository;


    @Override
    public EventStatusDTO confirmEvent(EventToApproveDTO eventToApproveDTO) {
        if(isTimeIsReserved(eventToApproveDTO)) {
            return new EventStatusDTO(eventToApproveDTO.getId(), EventStatus.APPROVED);
        } else {
            return new EventStatusDTO(eventToApproveDTO.getId(), EventStatus.REJECTED);
        }
    }

    private boolean isTimeIsReserved (EventToApproveDTO eventToApproveDTO) {
        if (reservedEventRepository.existsReservedEventByEventDate(eventToApproveDTO.getEventDate())){
            return false;
        } else {
            ReservedEvent reservedEvent = ReservedEvent.builder().eventDate(eventToApproveDTO.getEventDate()).build();
            reservedEventRepository.save(reservedEvent);
            return true;
        }
    }
}
