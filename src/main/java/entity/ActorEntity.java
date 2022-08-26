package entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "actor", schema = "public", catalog = "postgres")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class ActorEntity {
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @Id
    @Column(name = "actor_id", nullable = false)
    private int actorId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Basic
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;
//    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
//    private List<FilmActorEntity> filmActorEntityList;












//    public int getActorId() {
//        return actorId;
//    }
//
//    public void setActorId(int actorId) {
//        this.actorId = actorId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Timestamp getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setLastUpdate(Timestamp lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ActorEntity that = (ActorEntity) o;
//        return actorId == that.actorId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(lastUpdate, that.lastUpdate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(actorId, firstName, lastName, lastUpdate);
//    }
}
