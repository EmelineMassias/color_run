package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.dto.ParticipantDto;
import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T21:25:42+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250115-2156, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class InscriptionMapperImpl implements InscriptionMapper {

    @Override
    public Inscription toEntity(InscriptionDto inscriptionDto) {
        if ( inscriptionDto == null ) {
            return null;
        }

        Inscription inscription = new Inscription();

        inscription.setId( inscriptionDto.getId() );
        inscription.setParticipant( participantDtoToParticipant( inscriptionDto.getParticipant() ) );
        inscription.setCourse( courseDtoToCourse( inscriptionDto.getCourse() ) );

        return inscription;
    }

    @Override
    public InscriptionDto toDto(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }

        InscriptionDto inscriptionDto = new InscriptionDto();

        inscriptionDto.setCourse( courseToCourseDto( inscription.getCourse() ) );
        inscriptionDto.setId( inscription.getId() );
        inscriptionDto.setParticipant( participantToParticipantDto( inscription.getParticipant() ) );

        return inscriptionDto;
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

    protected Participant participantDtoToParticipant(ParticipantDto participantDto) {
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

    protected Course courseDtoToCourse(CourseDto courseDto) {
        if ( courseDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( courseDto.getId() );
        course.setDateHeureCourse( courseDto.getDateHeureCourse() );
        course.setDescription( courseDto.getDescription() );
        course.setDistance( courseDto.getDistance() );
        course.setLieu( courseDto.getLieu() );
        course.setNbMaxParticipants( courseDto.getNbMaxParticipants() );
        course.setPrixCourse( courseDto.getPrixCourse() );
        course.setCauseSoutenue( courseDto.getCauseSoutenue() );
        course.setHaveObstacle( courseDto.getHaveObstacle() );

        return course;
    }

    protected CourseDto courseToCourseDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setDateHeureCourse( course.getDateHeureCourse() );
        courseDto.setDescription( course.getDescription() );
        courseDto.setDistance( course.getDistance() );
        courseDto.setLieu( course.getLieu() );
        courseDto.setNbMaxParticipants( course.getNbMaxParticipants() );
        courseDto.setPrixCourse( course.getPrixCourse() );
        courseDto.setCauseSoutenue( course.getCauseSoutenue() );
        courseDto.setHaveObstacle( course.getHaveObstacle() );

        return courseDto;
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

    protected ParticipantDto participantToParticipantDto(Participant participant) {
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
}
