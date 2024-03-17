package kevserbusrayildirim.userreviewservice.entity;

import jakarta.persistence.*;
import kevserbusrayildirim.userreviewservice.client.Restaurant;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String text;

    @Enumerated(EnumType.ORDINAL)
    public Score score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @JoinColumn(name = "restaurant_id")
    public Long restaurantId;
}
