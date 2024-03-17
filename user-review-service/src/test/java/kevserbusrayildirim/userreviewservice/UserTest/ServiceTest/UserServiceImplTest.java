package kevserbusrayildirim.userreviewservice.UserTest.ServiceTest;

import kevserbusrayildirim.userreviewservice.client.RecommenderClient;
import kevserbusrayildirim.userreviewservice.exception.ResourceNotFoundException;
import kevserbusrayildirim.userreviewservice.model.request.RecommenderRequest;
import kevserbusrayildirim.userreviewservice.model.request.UserCreateRequest;
import kevserbusrayildirim.userreviewservice.model.response.RecommenderResponse;
import kevserbusrayildirim.userreviewservice.repository.UserRepository;
import kevserbusrayildirim.userreviewservice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RecommenderClient recommenderClient;


    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserCreateRequest() {
        // Given
        String name = "John";
        String surname = "Doe";
        String latitude = "40.7128";
        String longitude = "74.0060";

        // When
        UserCreateRequest request = new UserCreateRequest();
        request.setName(name);
        request.setSurname(surname);
        request.setLatitude(latitude);
        request.setLongitude(longitude);

        // Then
        assertNotNull(request);
        assertEquals(name, request.getName());
        assertEquals(surname, request.getSurname());
        assertEquals(latitude, request.getLatitude());
        assertEquals(longitude, request.getLongitude());
    }



    @Test
    void deleteUser() {
        // Given
        Long userId = 1L;

        // When
        userService.deleteUser(userId);

        // Then
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testGetUserById_UserNotFound() {

        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> userService.getUserById(userId));
    }

    @Test
    void getAllUsers() {
        // Given
        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        // When
        userService.getAllUsers();

        // Then
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void getRecommendedRestaurantsByUserLocation() {
        // Given
        RecommenderRequest recommenderRequest = new RecommenderRequest();
        when(recommenderClient.getRecommendedRestaurantsByUserLocation(recommenderRequest)).thenReturn(new RecommenderResponse());

        // When
        RecommenderResponse response = userService.getRecommendedRestaurantsByUserLocation(recommenderRequest);

        // Then
        assertNotNull(response);
        verify(recommenderClient, times(1)).getRecommendedRestaurantsByUserLocation(recommenderRequest);
    }
}

