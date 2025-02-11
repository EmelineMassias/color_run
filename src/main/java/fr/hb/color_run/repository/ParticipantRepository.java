package fr.hb.color_run.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hb.color_run.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long>{
    Optional<Participant> findByEmail(String email);
}
