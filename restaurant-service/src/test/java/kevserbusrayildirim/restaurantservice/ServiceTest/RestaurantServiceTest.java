package kevserbusrayildirim.restaurantservice.ServiceTest;

import kevserbusrayildirim.restaurantservice.dto.RestaurantDto;
import kevserbusrayildirim.restaurantservice.entity.Restaurant;
import kevserbusrayildirim.restaurantservice.mapper.RestaurantMapper;
import kevserbusrayildirim.restaurantservice.model.request.RecommendRequest;
import kevserbusrayildirim.restaurantservice.model.request.RestaurantRequest;
import kevserbusrayildirim.restaurantservice.model.response.RecommendResponse;
import kevserbusrayildirim.restaurantservice.model.response.RestaurantSolrResponse;
import kevserbusrayildirim.restaurantservice.repository.RestaurantRepository;
import kevserbusrayildirim.restaurantservice.service.impl.RestaurantServiceImpl;
import kevserbusrayildirim.restaurantservice.utils.Utils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private RestaurantMapper restaurantMapper;

    @Mock
    private Utils utils;

    @InjectMocks
    private RestaurantServiceImpl restaurantService;

    @Test
    public void testCreateRestaurant() {
        RestaurantRequest restaurantRequest = new RestaurantRequest();
        Restaurant savedRestaurant = new Restaurant();
        RestaurantDto restaurantDto = new RestaurantDto();
        when(restaurantRepository.save(any())).thenReturn(savedRestaurant);
        when(restaurantMapper.restaurantToRestaurantDTO(any())).thenReturn(restaurantDto);

        RestaurantDto result = restaurantService.createRestaurant(restaurantRequest);

        assertEquals(restaurantDto, result);
        verify(restaurantRepository, times(1)).save(any());
        verify(restaurantMapper, times(1)).restaurantToRestaurantDTO(any());
    }

    @Test
    public void testGetAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        when(restaurantRepository.findAll()).thenReturn(restaurants);

        RestaurantSolrResponse result = restaurantService.getAllRestaurants();

        assertEquals(restaurants.size(), result.getRestaurants().size());
        verify(restaurantRepository, times(1)).findAll();
    }

    @Test
    public void testRecommendedRestaurants() {
        // Arrange
        RecommendRequest recommendRequest = new RecommendRequest();
        recommendRequest.setLatitude("40.7128");
        recommendRequest.setLongitude("-74.0061");

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId("1");
        restaurant1.setLatitude("40.7128");
        restaurant1.setLongitude("-74.0060");
        restaurant1.setScore("4");
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(restaurant1);
        when(restaurantRepository.findAll()).thenReturn(restaurants);

        RecommendResponse result = restaurantService.recommendedRestaurants(recommendRequest);

        assertNotNull(result);
        assertNotNull(result.getRestaurants());
        assertEquals(1, result.getRestaurants().size());
        assertEquals("1", result.getRestaurants().get(0).getId());
    }

    @Test
    public void testUpdateRestaurant() {
        String restaurantId = "testId";
        Restaurant restaurant = new Restaurant();
        Restaurant existingRestaurant = new Restaurant();
        Restaurant updatedRestaurant = new Restaurant();
        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(existingRestaurant));
        when(restaurantRepository.save(existingRestaurant)).thenReturn(updatedRestaurant);
        when(restaurantMapper.restaurantToRestaurantDTO(updatedRestaurant)).thenReturn(new RestaurantDto());

        RestaurantDto result = restaurantService.updateRestaurant(restaurantId, restaurant);

        assertEquals(updatedRestaurant.getName(), restaurant.getName());
    }

    @Test
    public void testDeleteRestaurant() {
        String restaurantId = "testId";
        Restaurant existingRestaurant = new Restaurant();
        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(existingRestaurant));

        restaurantService.deleteRestaurant(restaurantId);

        verify(restaurantRepository, times(1)).delete(existingRestaurant);
    }
}

