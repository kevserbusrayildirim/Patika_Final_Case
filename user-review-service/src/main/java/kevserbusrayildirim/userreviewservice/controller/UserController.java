package kevserbusrayildirim.userreviewservice.controller;

import kevserbusrayildirim.userreviewservice.controller.contract.UserControllerContract;
import kevserbusrayildirim.userreviewservice.dto.UserDto;
import kevserbusrayildirim.userreviewservice.entity.User;
import kevserbusrayildirim.userreviewservice.model.request.RecommenderRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserCreateRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserUpdateRequest;
import kevserbusrayildirim.userreviewservice.model.response.RecommenderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserControllerContract userControllerContract;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreateRequest request){
        UserDto createdUser = userControllerContract.createUser(request);
        logger.info("UserController: createUser method called");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userControllerContract.getAllUsers();
        logger.info("UserController: getAllUsers method called");
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @PostMapping("/recommended-restaurants")
    public RecommenderResponse getRecommendedRestaurantsByUserLocation(@RequestBody RecommenderRequest recommenderRequest){
        logger.info("UserController: getRecommendedRestaurantsByUserLocation method called");
        return userControllerContract.getRecommendedRestaurantsByUserLocation(recommenderRequest);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserByID(@PathVariable Long userId){
        UserDto foundedUser = userControllerContract.getUserByID(userId);
        logger.info("UserController: getUserByID method called");
        return ResponseEntity.status(HttpStatus.OK).body(foundedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userControllerContract.deleteUser(userId);
        logger.info("UserController: deleteUser method called");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        UserDto updatedUserDto = userControllerContract.updateUser(userId, request);
        logger.info("UserController: updateUser method called");
        return ResponseEntity.status(HttpStatus.OK).body(updatedUserDto);
    }

}