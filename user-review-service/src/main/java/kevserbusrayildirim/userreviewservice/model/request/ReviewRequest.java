package kevserbusrayildirim.userreviewservice.model.request;

import kevserbusrayildirim.userreviewservice.entity.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    public String text;
    public Score score;
    public Long userId;
    public  Long restaurantId;
}
