package com.ld.confirmationfornotificator.dto;


import com.ld.confirmationfornotificator.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventStatusDTO {

    private Long id;

    private EventStatus eventStatus;
}
