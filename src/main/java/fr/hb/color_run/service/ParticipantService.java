package fr.hb.color_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.ParticipantDto;
import fr.hb.color_run.model.Participant;

@Service
public interface ParticipantService {

    Participant saveParticipant(ParticipantDto participantDto);
    
    List<ParticipantDto> getAllParticipants();

    ParticipantDto getParticipantById(Long id);

    void deleteParticipant(Long id);

}
