package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.ParticipantDto;
import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T21:25:41+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ParticipantMapperImpl implements ParticipantMapper {

    @Override
    public Participant toEntity(ParticipantDto participantDto) {
        if ( participantDto == null ) {
            return null;
        }

        Participant participant = new Participant();

        participant.setId( participantDto.getId() );
        participant.setNom( participantDto.getNom() );
        participant.setPrenom( participantDto.getPrenom() );
        participant.setEmail( participantDto.getEmail() );
        participant.setPhoto( participantDto.getPhoto() );
        participant.setMotDePasse( participantDto.getMotDePasse() );
        participant.setRole( roleDtoToRole( participantDto.getRole() ) );

        return participant;
    }

    @Override
    public ParticipantDto toDto(Participant participant) {
        if ( participant == null ) {
            return null;
        }

        ParticipantDto participantDto = new ParticipantDto();

        participantDto.setId( participant.getId() );
        participantDto.setNom( participant.getNom() );
        participantDto.setPrenom( participant.getPrenom() );
        participantDto.setEmail( participant.getEmail() );
        participantDto.setPhoto( participant.getPhoto() );
        participantDto.setMotDePasse( participant.getMotDePasse() );
        participantDto.setRole( roleToRoleDto( participant.getRole() ) );

        return participantDto;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setLibelle( roleDto.getLibelle() );

        return role;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setLibelle( role.getLibelle() );

        return roleDto;
    }
}
