package fr.hb.color_run.service.impl;

import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.mapper.ParcoursMapper;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Parcours;
import fr.hb.color_run.repository.CourseRepository;
import fr.hb.color_run.repository.ParcoursRepository;
import fr.hb.color_run.service.ParcoursService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ParcoursServiceImpl implements ParcoursService{

    private ParcoursMapper parcoursMapper;
    private ParcoursRepository parcoursRepository;
    private CourseRepository courseRepository;

    public ParcoursServiceImpl(ParcoursRepository parcoursRepository,
                            ParcoursMapper parcoursMapper,
                            CourseRepository courseRepository){
        this.parcoursRepository = parcoursRepository;
        this.parcoursMapper = parcoursMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public Parcours saveParcours(ParcoursDto parcoursDto) {
        Parcours parcours = parcoursMapper.toEntity(parcoursDto);
        if(parcoursDto.getCourseId() != null &&
        parcoursDto.getCourseId().isEmpty()){
            List<Course> courses = courseRepository
            .findAllById(parcoursDto.getCourseId());
            parcours.setCourses(courses);
        }
        return parcoursRepository.save(parcours);
    }

    @Override
    public List<ParcoursDto> getAllParcours(){
        List<Parcours> parcours = parcoursRepository.findAll();
        return parcours.stream().map(parcoursMapper::toDto)
        .collect(Collectors.toList());
    }
    
    @Override
    public ParcoursDto getParcoursById(Long id){
        return parcoursRepository
        .findById(id).map(parcoursMapper::toDto)
        .orElse(null);
    }

    @Override
    public void deleteParcours(Long id){
        parcoursRepository.deleteById(id);
    }
}
