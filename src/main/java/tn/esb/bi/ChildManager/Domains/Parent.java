package tn.esb.bi.ChildManager.Domains;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
//@EqualsAndHashCode
@Entity
public class Parent {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @OneToMany(mappedBy="parent",cascade= CascadeType.ALL)
    private Set<Child> children = new HashSet<>();

    public Parent(Long id, @NonNull String name, Set<Child> children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }
}
