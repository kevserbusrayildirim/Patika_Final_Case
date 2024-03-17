package kevserbusrayildirim.userreviewservice.service;

import kevserbusrayildirim.userreviewservice.entity.User;
import kevserbusrayildirim.userreviewservice.dto.UserDto;
import kevserbusrayildirim.userreviewservice.model.request.RecommenderRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserCreateRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserUpdateRequest;
import kevserbusrayildirim.userreviewservice.model.response.RecommenderResponse;

import java.util.List;

public interface UserService {
    UserDto createUser(UserCreateRequest request);
    UserDto updateUser(Long userId, UserUpdateRequest request);
    void deleteUser(Long userId);
    UserDto getUserById(Long userId);
    List<User> getAllUsers();
    RecommenderResponse getRecommendedRestaurantsByUserLocation(RecommenderRequest recommenderRequest);
}

