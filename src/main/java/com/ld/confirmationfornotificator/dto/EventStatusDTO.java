package com.ld.confirmationfornotificator.dto;


import com.ld.confirmationfornotificator.enums.EventStatus;
import lombok.Data;

@Data
public class EventStatusDTO {

    private Long id;

    private EventStatus eventStatus;
}
