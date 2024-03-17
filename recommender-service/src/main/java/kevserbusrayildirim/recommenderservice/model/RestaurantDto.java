package kevserbusrayildirim.recommenderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private String id;
    private String name;
    private String address;
    private String score;
    private String latitude;
    private String longitude;
}
