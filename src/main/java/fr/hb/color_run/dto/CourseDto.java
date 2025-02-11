package fr.hb.color_run.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto implements Serializable{

    Long id;
    private LocalDateTime dateHeureCourse;

    private String description;
    private Float distance;
    private String lieu;
    private Double nbMaxParticipants;
    private Float prixCourse;
    private String causeSoutenue;
    private Boolean haveObstacle;
    private List<Long> parcoursId;
    private List<Long> inscriptionId;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateHeureCourse() {
        return this.dateHeureCourse;
    }

    public void setDateHeureCourse(LocalDateTime dateHeureCourse) {
        this.dateHeureCourse = dateHeureCourse;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getDistance() {
        return this.distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getLieu() {
        return this.lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Double getNbMaxParticipants() {
        return this.nbMaxParticipants;
    }

    public void setNbMaxParticipants(Double nbMaxParticipants) {
        this.nbMaxParticipants = nbMaxParticipants;
    }

    public Float getPrixCourse() {
        return this.prixCourse;
    }

    public void setPrixCourse(Float prixCourse) {
        this.prixCourse = prixCourse;
    }

    public String getCauseSoutenue() {
        return this.causeSoutenue;
    }

    public void setCauseSoutenue(String causeSoutenue) {
        this.causeSoutenue = causeSoutenue;
    }

    public Boolean isHaveObstacle() {
        return this.haveObstacle;
    }

    public Boolean getHaveObstacle() {
        return this.haveObstacle;
    }

    public void setHaveObstacle(Boolean haveObstacle) {
        this.haveObstacle = haveObstacle;
    }

    public List<Long> getParcoursId() {
        return this.parcoursId;
    }

    public void setParcoursId(List<Long> parcoursId) {
        this.parcoursId = parcoursId;
    }

    public List<Long> getInscriptionId() {
        return this.inscriptionId;
    }

    public void setInscriptionId(List<Long> inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

}
