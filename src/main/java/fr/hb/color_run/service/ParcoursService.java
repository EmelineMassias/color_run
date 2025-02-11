package fr.hb.color_run.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.model.Parcours;

@Service
public interface ParcoursService {

    Parcours saveParcours(ParcoursDto parcoursDto);
    List<ParcoursDto> getAllParcours();

    ParcoursDto getParcoursById(Long id);

    void deleteParcours(Long id);

}
