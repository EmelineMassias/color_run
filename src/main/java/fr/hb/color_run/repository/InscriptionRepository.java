package fr.hb.color_run.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Participant;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long>{
//Méthode dérivée pour récupérer les inscriptions d'un participant
    List<Inscription> findByParticipant(Participant participant);

}
