package fr.hb.color_run.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    Role toEntity(RoleDto roleDto);

    @Mapping(target = "participantId", source ="participants")
    RoleDto toDto(Role role);

    List<Long> mapParticipant(List<Participant> participants);
    default Long map(Participant participant){
        return participant!=null?participant.getId():null;
    }

}
