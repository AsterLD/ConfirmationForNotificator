package com.ld.eventplannerapprover.dto;


import java.time.LocalDate;

public record EventToApproveDTO(Long id, String type, LocalDate eventDate, Long userId) {
}
