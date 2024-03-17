package kevserbusrayildirim.userreviewservice.service.impl;

import kevserbusrayildirim.userreviewservice.client.RecommenderClient;
import kevserbusrayildirim.userreviewservice.dto.UserDto;
import kevserbusrayildirim.userreviewservice.entity.User;
import kevserbusrayildirim.userreviewservice.exception.ResourceNotFoundException;
import kevserbusrayildirim.userreviewservice.mapper.UserMapper;
import kevserbusrayildirim.userreviewservice.model.request.RecommenderRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserCreateRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserUpdateRequest;
import kevserbusrayildirim.userreviewservice.model.response.RecommenderResponse;
import kevserbusrayildirim.userreviewservice.repository.UserRepository;
import kevserbusrayildirim.userreviewservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecommenderClient recommenderClient;

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDto createUser(UserCreateRequest request) {

        User savedUser = userRepository.save(userMapper.userRequestToUserEntity(request));
        logger.info("UserServiceImpl: User created: " + savedUser.getId());
        return userMapper.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(Long userId, UserUpdateRequest request) {
        User foundedUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        foundedUser.setName(request.getName());
        foundedUser.setSurname(request.getSurname());
        foundedUser.setLatitude(request.getLatitude());
        foundedUser.setLongitude(request.getLongitude());

        User updatedUser = userRepository.save(foundedUser);
        logger.info("UserServiceImpl: User updated: " + updatedUser.getId());
        return userMapper.userToDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        logger.info("UserServiceImpl: User deleted.");
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        logger.info("UserServiceImpl: Get user with id: " + userId);
        return userMapper.userToDto(user);
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("UserServiceImpl: All users.");
        return userRepository.findAll();
    }

    @Override
    public RecommenderResponse getRecommendedRestaurantsByUserLocation(RecommenderRequest recommenderRequest) {
        logger.info("UserServiceImpl: Recommended Restaurants by user ID");
        return recommenderClient.getRecommendedRestaurantsByUserLocation(recommenderRequest);
    }


}
