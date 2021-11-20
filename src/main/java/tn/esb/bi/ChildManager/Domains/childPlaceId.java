package tn.esb.bi.ChildManager.Domains;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Embeddable
public class childPlaceId implements Serializable {
    private Long childId;
    private Long placeId;
}
