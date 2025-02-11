package fr.hb.color_run.mapper;

import org.mapstruct.Mapper;


import fr.hb.color_run.dto.ParticipantDto;
import fr.hb.color_run.model.Participant;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {

    Participant toEntity(ParticipantDto participantDto);
    ParticipantDto toDto(Participant participant);

}
