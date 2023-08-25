package com.ld.confirmationfornotificator.service;

import com.ld.confirmationfornotificator.dto.EventStatusDTO;
import com.ld.confirmationfornotificator.dto.EventToApproveDTO;

public interface ConfirmationService {

    public EventStatusDTO confirmEvent(EventToApproveDTO eventToApproveDTO);
}
