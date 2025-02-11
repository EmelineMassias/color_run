package fr.hb.color_run.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeureCourse;

    private String description;

    private Float distance;

    private String lieu;

    private Double nbMaxParticipants;

    private Float prixCourse;

    private String causeSoutenue;

    private Boolean haveObstacle;

    @ManyToMany
    @JoinTable(
    name = "course_parcours",
    joinColumns = @JoinColumn(name = "course_id"), 
    inverseJoinColumns = @JoinColumn(name = "parcours_id")
    )
    private List<Parcours> parcours = new ArrayList<>();

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Inscription> inscriptions = new ArrayList<>();


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

    public List<Parcours> getParcours() {
        return this.parcours;
    }

    public void setParcours(List<Parcours> parcours) {
        this.parcours = parcours;
    }

    public List<Inscription> getInscriptions() {
        return this.inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", dateHeureCourse='" + getDateHeureCourse() + "'" +
            ", description='" + getDescription() + "'" +
            ", distance='" + getDistance() + "'" +
            ", lieu='" + getLieu() + "'" +
            ", nbMaxParticipants='" + getNbMaxParticipants() + "'" +
            ", prixCourse='" + getPrixCourse() + "'" +
            ", causeSoutenue='" + getCauseSoutenue() + "'" +
            ", haveObstacle='" + isHaveObstacle() + "'" +
            ", parcours='" + getParcours() + "'" +
            ", inscriptions='" + getInscriptions() + "'" +
            "}";
    }

}
