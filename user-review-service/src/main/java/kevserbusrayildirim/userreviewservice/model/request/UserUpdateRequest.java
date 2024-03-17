package kevserbusrayildirim.userreviewservice.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    public String name;
    public String surname;
    public String latitude;
    public String longitude;
}
