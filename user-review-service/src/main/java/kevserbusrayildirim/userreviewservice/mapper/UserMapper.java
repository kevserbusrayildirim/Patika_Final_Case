package kevserbusrayildirim.userreviewservice.mapper;

import kevserbusrayildirim.userreviewservice.dto.UserDto;
import kevserbusrayildirim.userreviewservice.entity.User;
import kevserbusrayildirim.userreviewservice.model.request.UserCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setLatitude(user.getLatitude());
        userDto.setLongitude(user.getLongitude());
        userDto.setReviews(user.getReviews());
        return userDto;
    }

    public User userDtoToUserEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setLatitude(userDto.getLatitude());
        user.setLongitude(userDto.getLongitude());
        return user;
    }

    public User userRequestToUserEntity(UserCreateRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setLatitude(request.getLatitude());
        user.setLongitude(request.getLongitude());
        return user;
    }

}
