package kevserbusrayildirim.userreviewservice.dto;

import kevserbusrayildirim.userreviewservice.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    public Long id;;
    public String name;
    public String surname;
    public String latitude;
    public String longitude;
    public List<Review> reviews;
}
