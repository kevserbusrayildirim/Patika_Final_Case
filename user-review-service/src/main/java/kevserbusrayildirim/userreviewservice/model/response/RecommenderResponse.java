package kevserbusrayildirim.userreviewservice.model.response;

import kevserbusrayildirim.userreviewservice.client.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommenderResponse {
    public List<Restaurant> restaurants;
}
