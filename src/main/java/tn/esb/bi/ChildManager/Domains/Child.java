package tn.esb.bi.ChildManager.Domains;

//import com.sun.istack.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "photo")
@Entity
//@Table(name="child_tab")
public class Child {
    @Id
    @GeneratedValue
    private Long id;
    @EqualsAndHashCode.Include
    @NonNull
    @Column(unique = true)
    private String firstName;
    @NonNull
    @EqualsAndHashCode.Include
    private String lastName;
    //private SimpleDateFormat birthDate;
    @EqualsAndHashCode.Include
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private String studyYear;
    //private String photo; //pour stocker le chemin de la photo
    //ou bien
    private byte[] photo;//pour stocker la photo elle même
    //lien entre Child et Task
    @OneToMany(mappedBy="child",cascade=CascadeType.ALL)
    private Set<childPlace> childPlaces=new HashSet<>();
    @OneToMany(mappedBy="child",cascade=CascadeType.ALL)
    private Set<Task> childTasks = new HashSet<>();
    @ManyToOne
    @JoinColumn(name="id_parent",referencedColumnName = "id")
    private Parent parent;


}
