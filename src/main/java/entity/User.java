package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_data", schema = "todolist", catalog = "postgres")
@Getter @Setter @ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "userpassword", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "username", nullable = false, length = -1)
    private String name;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Category> categories;

}
