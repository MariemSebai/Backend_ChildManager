package tn.esb.bi.ChildManager.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import tn.esb.bi.ChildManager.Enumerations.TaskState;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //remplace @Getter, @Setter, @RequiredArgsConstructor, @EqualsAndHashCode, @ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "photo")
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String name;
    private double duration;
    @NonNull
    @EqualsAndHashCode.Include
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;
    private TaskState state;
    @EqualsAndHashCode.Include
    private String type;
    @ManyToOne
    @JoinColumn(name="id_child",referencedColumnName = "id")
    private Child child;//Le child ciblé par la tâche
    @ManyToOne
    @JoinColumn(name="id_location",referencedColumnName = "id")
    private Location taskLocation;


}
