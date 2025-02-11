package fr.hb.color_run.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hb.color_run.model.Participant;
import fr.hb.color_run.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByParticipants(Participant participant);

}
