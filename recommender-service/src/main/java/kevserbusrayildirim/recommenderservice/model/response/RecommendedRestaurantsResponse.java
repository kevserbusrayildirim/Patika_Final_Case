package kevserbusrayildirim.recommenderservice.model.response;
import kevserbusrayildirim.recommenderservice.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendedRestaurantsResponse {
    public List<Restaurant> restaurants;
}
