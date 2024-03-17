package kevserbusrayildirim.userreviewservice.controller.contract;

import kevserbusrayildirim.userreviewservice.dto.UserDto;
import kevserbusrayildirim.userreviewservice.entity.User;
import kevserbusrayildirim.userreviewservice.model.request.RecommenderRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserCreateRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserUpdateRequest;
import kevserbusrayildirim.userreviewservice.model.response.RecommenderResponse;

import java.util.List;

public interface UserControllerContract {
    UserDto createUser(UserCreateRequest request);
    List<User> getAllUsers();
    RecommenderResponse getRecommendedRestaurantsByUserLocation(RecommenderRequest recommenderRequest);
    UserDto getUserByID(Long userId);
    void deleteUser(Long userId);
    UserDto updateUser(Long userId, UserUpdateRequest request);
}
