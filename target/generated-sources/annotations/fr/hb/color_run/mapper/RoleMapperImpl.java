package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T21:25:42+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setLibelle( roleDto.getLibelle() );

        return role;
    }

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setParticipantId( mapParticipant( role.getParticipants() ) );
        roleDto.setId( role.getId() );
        roleDto.setLibelle( role.getLibelle() );

        return roleDto;
    }

    @Override
    public List<Long> mapParticipant(List<Participant> participants) {
        if ( participants == null ) {
            return null;
        }

        List<Long> list = new ArrayList<Long>( participants.size() );
        for ( Participant participant : participants ) {
            list.add( map( participant ) );
        }

        return list;
    }
}
