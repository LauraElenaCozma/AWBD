package com.awbd.lab6.repositories;

import com.awbd.lab6.domain.Participant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
    List<Participant> findByLastNameLike(String lastName);
    List<Participant> findByIdIn(List<Long> ids);
}