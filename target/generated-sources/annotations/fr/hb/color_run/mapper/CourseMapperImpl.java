package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Parcours;
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
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toEntity(CourseDto courseDto) {
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

    @Override
    public CourseDto toDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setParcoursId( mapParcours( course.getParcours() ) );
        courseDto.setInscriptionId( mapInscription( course.getInscriptions() ) );
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

    @Override
    public List<Long> mapParcours(List<Parcours> parcours) {
        if ( parcours == null ) {
            return null;
        }

        List<Long> list = new ArrayList<Long>( parcours.size() );
        for ( Parcours parcours1 : parcours ) {
            list.add( map( parcours1 ) );
        }

        return list;
    }

    @Override
    public List<Long> mapInscription(List<Inscription> inscriptions) {
        if ( inscriptions == null ) {
            return null;
        }

        List<Long> list = new ArrayList<Long>( inscriptions.size() );
        for ( Inscription inscription : inscriptions ) {
            list.add( map( inscription ) );
        }

        return list;
    }
}
