package fr.hb.color_run.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionDto implements Serializable {
    Long id;
    //private Long participantId;
    //private Long courseId;
    private ParticipantDto participant; 
    private CourseDto course;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParticipantDto getParticipant() {
        return this.participant;
    }

    public void setParticipant(ParticipantDto participant) {
        this.participant = participant;
    }

    public CourseDto getCourse() {
        return this.course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

}
