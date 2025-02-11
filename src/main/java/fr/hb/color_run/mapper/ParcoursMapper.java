package fr.hb.color_run.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Parcours;

@Mapper(componentModel = "spring")
public interface ParcoursMapper {

    Parcours toEntity(ParcoursDto parcoursDto);

    @Mapping(target = "courseId", source ="courses")
    ParcoursDto toDto(Parcours parcours);

    List<Long> mapCourse(List<Course> courses);

    default Long map(Course course) {
        return course!=null?course.getId():null;
    }
}
