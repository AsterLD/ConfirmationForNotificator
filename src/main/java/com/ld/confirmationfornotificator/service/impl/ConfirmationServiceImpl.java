package com.ld.confirmationfornotificator.service.impl;

import com.ld.confirmationfornotificator.dto.EventStatusDTO;
import com.ld.confirmationfornotificator.dto.EventToApproveDTO;
import com.ld.confirmationfornotificator.entity.ReservedEvent;
import com.ld.confirmationfornotificator.enums.EventStatus;
import com.ld.confirmationfornotificator.repo.ReservedEventRepository;
import com.ld.confirmationfornotificator.service.ConfirmationService;
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
