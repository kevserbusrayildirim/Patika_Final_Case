package kevserbusrayildirim.userreviewservice.dto;

import kevserbusrayildirim.userreviewservice.entity.Score;
import kevserbusrayildirim.userreviewservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    public Long id;
    public String text;
    public Score score;
    public User user;
    public Long restaurantId;
}
