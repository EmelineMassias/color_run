package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.model.Course;
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
public class ParcoursMapperImpl implements ParcoursMapper {

    @Override
    public Parcours toEntity(ParcoursDto parcoursDto) {
        if ( parcoursDto == null ) {
            return null;
        }

        Parcours parcours = new Parcours();

        parcours.setId( parcoursDto.getId() );
        parcours.setLatitude( parcoursDto.getLatitude() );
        parcours.setLongitude( parcoursDto.getLongitude() );
        parcours.setOrdre( parcoursDto.getOrdre() );

        return parcours;
    }

    @Override
    public ParcoursDto toDto(Parcours parcours) {
        if ( parcours == null ) {
            return null;
        }

        ParcoursDto parcoursDto = new ParcoursDto();

        parcoursDto.setCourseId( mapCourse( parcours.getCourses() ) );
        parcoursDto.setId( parcours.getId() );
        parcoursDto.setLatitude( parcours.getLatitude() );
        parcoursDto.setLongitude( parcours.getLongitude() );
        parcoursDto.setOrdre( parcours.getOrdre() );

        return parcoursDto;
    }

    @Override
    public List<Long> mapCourse(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<Long> list = new ArrayList<Long>( courses.size() );
        for ( Course course : courses ) {
            list.add( map( course ) );
        }

        return list;
    }
}
