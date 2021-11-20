package tn.esb.bi.ChildManager.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Place {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Exclude
    private Long id;
    @NonNull
    private double attitude;
    @NonNull
    private double longitude;
    @OneToMany(mappedBy="child")
    private Set<childPlace> childrenplaces = new HashSet<>();

}
