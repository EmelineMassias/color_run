package fr.hb.color_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.model.Inscription;

@Service
public interface InscriptionService {

    Inscription saveInscription(InscriptionDto inscriptionDto);
    List<InscriptionDto> getAllInscriptions();

    InscriptionDto getInscriptionById(Long id);

    void deleteInscription(Long id);

}
