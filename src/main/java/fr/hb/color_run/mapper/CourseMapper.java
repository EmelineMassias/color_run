package fr.hb.color_run.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Parcours;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {

    Course toEntity(CourseDto courseDto);

    @Mapping(target = "parcoursId", source = "parcours")
    @Mapping(target ="inscriptionId", source = "inscriptions")
    CourseDto toDto(Course course);

    List<Long> mapParcours(List<Parcours> parcours);

    default Long map(Parcours parcours) {
        return parcours!=null?parcours.getId():null;
    }

    List<Long> mapInscription(List<Inscription> inscriptions);

    default Long map(Inscription inscription){
        return inscription!=null?inscription.getId() :null;
    }
}

