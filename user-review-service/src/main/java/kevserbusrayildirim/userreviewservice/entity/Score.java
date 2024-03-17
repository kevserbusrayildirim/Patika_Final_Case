package kevserbusrayildirim.userreviewservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum Score {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    public final int value;

}
