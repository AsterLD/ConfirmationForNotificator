package com.ld.eventplannerapprover.dto;


import com.ld.eventplannerapprover.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventStatusDTO {

    private Long id;

    private EventStatus eventStatus;
}
