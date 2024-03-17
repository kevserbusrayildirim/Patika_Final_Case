package kevserbusrayildirim.recommenderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    public String id;
    public String name;
    public String address;
    public String score;
    public String latitude;
    public String longitude;
}
