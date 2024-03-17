package kevserbusrayildirim.userreviewservice.controller.contract.impl;

import kevserbusrayildirim.userreviewservice.controller.contract.UserControllerContract;
import kevserbusrayildirim.userreviewservice.dto.UserDto;
import kevserbusrayildirim.userreviewservice.entity.User;
import kevserbusrayildirim.userreviewservice.model.request.RecommenderRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserCreateRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserUpdateRequest;
import kevserbusrayildirim.userreviewservice.model.response.RecommenderResponse;
import kevserbusrayildirim.userreviewservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserControllerContractImpl implements UserControllerContract {

    @Autowired
    private UserService userService;
    @Override
    public UserDto createUser(UserCreateRequest request) {
        return userService.createUser(request);
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public RecommenderResponse getRecommendedRestaurantsByUserLocation(RecommenderRequest recommenderRequest) {
        return userService.getRecommendedRestaurantsByUserLocation(recommenderRequest);
    }

    @Override
    public UserDto getUserByID(Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return userDto;
    }

    @Override
    public void deleteUser(Long userId) {
        userService.deleteUser(userId);
    }

    @Override
    public UserDto updateUser(Long userId, UserUpdateRequest request) {
        return userService.updateUser(userId,request);
    }
}

