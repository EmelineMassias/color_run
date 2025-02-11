package fr.hb.color_run.model;

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
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;


    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<Participant> participants = new ArrayList<>();


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", participants='" + getParticipants() + "'" +
            "}";
    }

}
