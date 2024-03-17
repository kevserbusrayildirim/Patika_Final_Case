package kevserbusrayildirim.userreviewservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String surname;
    public String latitude;
    public String longitude;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Review> reviews;

    public User(){
        this.reviews = new ArrayList<>();
    }
}
