package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@NoArgsConstructor @AllArgsConstructor @ToString
@Setter @Getter @EqualsAndHashCode
public class Category {
    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic
    @Column(name = "completed_count", nullable = true, updatable = false)
    private Long completedCount;
    @Basic
    @Column(name = "uncompleted_count", nullable = true, updatable = false)
    private Long uncompletedCount;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
