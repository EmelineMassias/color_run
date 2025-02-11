package fr.hb.color_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;

@Service
public interface CourseService {

    Course saveCourse(CourseDto courseDto);
    
    List<CourseDto> getAllCourses();

    CourseDto getCourseById(Long id);

    void deleteCourse(Long id);
}
