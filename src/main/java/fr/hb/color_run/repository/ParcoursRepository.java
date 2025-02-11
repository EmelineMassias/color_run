package fr.hb.color_run.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hb.color_run.model.Parcours;

@Repository
public interface ParcoursRepository extends JpaRepository<Parcours, Long>{

}
