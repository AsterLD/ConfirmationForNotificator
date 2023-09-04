package com.ld.eventplannerapprover.service;

import com.ld.eventplannerapprover.dto.EventStatusDTO;
import com.ld.eventplannerapprover.dto.EventToApproveDTO;

public interface ConfirmationService {

    public EventStatusDTO confirmEvent(EventToApproveDTO eventToApproveDTO);
}
