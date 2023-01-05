package com.awbd.lab6.services;

import com.awbd.lab6.domain.Participant;

import javax.servlet.http.Part;

public interface ParticipantService {
    Participant findById(Long l);
    Participant save(Participant participant);
}
