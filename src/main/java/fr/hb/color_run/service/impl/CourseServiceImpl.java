package fr.hb.color_run.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.mapper.CourseMapper;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Parcours;
import fr.hb.color_run.repository.CourseRepository;
import fr.hb.color_run.repository.InscriptionRepository;
import fr.hb.color_run.repository.ParcoursRepository;
import fr.hb.color_run.service.CourseService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;
    private CourseRepository courseRepository;
    private ParcoursRepository parcoursRepository;
    private InscriptionRepository inscriptionRepository;

public CourseServiceImpl(CourseRepository courseRepository,
                        CourseMapper courseMapper,
                        ParcoursRepository parcoursRepository,
                        InscriptionRepository inscriptionRepository){

    this.courseRepository = courseRepository;
    this.courseMapper = courseMapper;
    this.parcoursRepository = parcoursRepository;
    this.inscriptionRepository = inscriptionRepository;

    }

    @Override
    public Course saveCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        if(courseDto.getParcoursId() != null &&
        courseDto.getParcoursId().isEmpty()){
            List<Parcours> parcours = parcoursRepository
            .findAllById(courseDto.getParcoursId());
            course.setParcours(parcours);
        }
        if(courseDto.getInscriptionId() !=null &&
        courseDto.getInscriptionId(). isEmpty()){
            List<Inscription> inscriptions = inscriptionRepository
            .findAllById(courseDto.getInscriptionId());
            course.setInscriptions(inscriptions);
        }

        return courseRepository.save(course);
    }

    @Override
    public List<CourseDto> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(courseMapper::toDto)
        .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long id){
        Course course = courseRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));
    return courseMapper.toDto(course);
    }

    @Override
    public void deleteCourse(Long id){

        courseRepository.deleteById(id);
    }
}
