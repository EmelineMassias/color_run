package fr.hb.color_run.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.model.Inscription;

@Mapper(componentModel = "spring")
public interface InscriptionMapper {

    Inscription toEntity(InscriptionDto inscriptionDto);

    @Mapping(target = "course", source = "course")
    InscriptionDto toDto(Inscription inscription);

    
}
