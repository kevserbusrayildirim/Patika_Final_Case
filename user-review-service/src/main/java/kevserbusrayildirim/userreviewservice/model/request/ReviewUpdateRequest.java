package kevserbusrayildirim.userreviewservice.model.request;

import kevserbusrayildirim.userreviewservice.entity.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewUpdateRequest {
    public String text;
    public Score score;
}
