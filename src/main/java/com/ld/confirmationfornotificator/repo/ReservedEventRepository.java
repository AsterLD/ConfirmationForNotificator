package com.ld.confirmationfornotificator.repo;

import com.ld.confirmationfornotificator.entity.ReservedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservedEventRepository extends JpaRepository<ReservedEvent, Long> {
    boolean existsReservedEventByEventDate(LocalDate eventDate);
}

