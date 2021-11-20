package tn.esb.bi.ChildManager.Domains;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class childPlace {
    @EmbeddedId
    private childPlaceId id;//clé primaire composite
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    @MapsId("childId")
    private Child child;
    @ManyToOne
    @MapsId("placeId")
    private Place place;


}
