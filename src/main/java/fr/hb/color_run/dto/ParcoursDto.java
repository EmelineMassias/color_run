package fr.hb.color_run.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParcoursDto implements Serializable {
    Long id;
    private Double latitude;
    private Double longitude;
    private Double ordre;
    private List<Long> courseId; 


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getOrdre() {
        return this.ordre;
    }

    public void setOrdre(Double ordre) {
        this.ordre = ordre;
    }

    public List<Long> getCourseId() {
        return this.courseId;
    }

    public void setCourseId(List<Long> courseId) {
        this.courseId = courseId;
    }

}
