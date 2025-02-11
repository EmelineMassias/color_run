package fr.hb.color_run.service.impl;

import org.springframework.stereotype.Service;


import fr.hb.color_run.dto.ParticipantDto;
import fr.hb.color_run.mapper.ParticipantMapper;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.repository.InscriptionRepository;
import fr.hb.color_run.repository.ParticipantRepository;
import fr.hb.color_run.repository.RoleRepository;
import fr.hb.color_run.service.ParticipantService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantMapper participantMapper;
    private ParticipantRepository participantRepository;
    private InscriptionRepository inscriptionRepository;   

    public ParticipantServiceImpl(ParticipantRepository participantRepository,
                            ParticipantMapper participantMapper,
                            InscriptionRepository inscriptionRepository,
                            RoleRepository roleRepository){
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Participant saveParticipant(ParticipantDto participantDto) {
        Participant participant = participantMapper.toEntity(participantDto);
        if(participant.getInscriptions() != null &&
        participant.getInscriptions().isEmpty()){
            List<Inscription> inscriptions = inscriptionRepository
            .findByParticipant(participant);
            participant.setInscriptions(inscriptions);
        }
        return participantRepository.save(participant);
    }

    @Override
    public List<ParticipantDto> getAllParticipants(){
        List<Participant> participants = participantRepository.findAll();
        return participants.stream().map(participantMapper::toDto)
        .collect(Collectors.toList());
    }

    @Override
    public ParticipantDto getParticipantById(Long id){
        return participantRepository
        .findById(id).map(participantMapper::toDto)
        .orElse(null);
    }

    @Override
    public void deleteParticipant(Long id){
        participantRepository.deleteById(id);
    }
}

