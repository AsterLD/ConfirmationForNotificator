package com.ld.confirmationfornotificator.service.impl;

import com.ld.confirmationfornotificator.dto.EventStatusDTO;
import com.ld.confirmationfornotificator.dto.EventToApproveDTO;
import com.ld.confirmationfornotificator.enums.EventStatus;
import com.ld.confirmationfornotificator.service.ConfirmationService;

import java.time.LocalDate;

public class ConfirmationServiceImpl implements ConfirmationService {
    @Override
    public EventStatusDTO confirmEvent(EventToApproveDTO eventToApproveDTO) {
        if(isTimeIsReserved(eventToApproveDTO.getEventDate())) {
            return new EventStatusDTO(eventToApproveDTO.getId(), EventStatus.APPROVED);
        } else {
            return new EventStatusDTO(eventToApproveDTO.getId(), EventStatus.REJECTED);
        }
    }

    private boolean isTimeIsReserved (LocalDate localDate) {
        return true;
    }
}
