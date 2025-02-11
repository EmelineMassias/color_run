package fr.hb.color_run.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {
    Long id;
    private String libelle;
    private List<Long> participantId;


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

    public List<Long> getParticipantId() {
        return this.participantId;
    }

    public void setParticipantId(List<Long> participantId) {
        this.participantId = participantId;
    }

}
