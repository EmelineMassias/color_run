package fr.hb.color_run.service.impl;

import java.util.stream.Collectors;

import java.util.List;
import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.mapper.InscriptionMapper;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.repository.CourseRepository;
import fr.hb.color_run.repository.InscriptionRepository;
import fr.hb.color_run.repository.ParticipantRepository;
import fr.hb.color_run.service.InscriptionService;

@Service
public class InscriptionServiceImpl implements InscriptionService{

    private InscriptionMapper inscriptionMapper;
    private InscriptionRepository inscriptionRepository;
    private ParticipantRepository participantRepository;
    private CourseRepository courseRepository;

public InscriptionServiceImpl(InscriptionRepository inscriptionRepository,
                            InscriptionMapper inscriptionMapper,
                            ParticipantRepository participantRepository,
                            CourseRepository courseRepository){
    this.inscriptionRepository = inscriptionRepository;
    this.inscriptionMapper = inscriptionMapper;
    this.participantRepository = participantRepository;
    this.courseRepository = courseRepository;
  }


@Override
public Inscription saveInscription(InscriptionDto inscriptionDto){
    Inscription inscription = inscriptionMapper.toEntity(inscriptionDto);
    if(inscription.getParticipant() !=null){
        Participant participant = participantRepository
        .findById(inscription.getParticipant().getId())
        .orElse(null);
        inscription.setParticipant(participant);
        }
    if(inscription.getCourse() !=null){
        Course course = courseRepository
        .findById(inscription.getCourse().getId())
        .orElse(null);
        inscription.setCourse(course);
        }
    return inscriptionRepository.save(inscription);
    }


@Override
public List<InscriptionDto> getAllInscriptions(){
    List<Inscription> inscriptions = inscriptionRepository.findAll();
    return inscriptions.stream().map(inscriptionMapper::toDto)
    .collect(Collectors.toList());
}

@Override
public InscriptionDto getInscriptionById(Long id){
    return inscriptionRepository
    .findById(id).map(inscriptionMapper::toDto)
    .orElse(null);
}

@Override
public void deleteInscription(Long id){
    inscriptionRepository.deleteById(id);
}

}    
    

