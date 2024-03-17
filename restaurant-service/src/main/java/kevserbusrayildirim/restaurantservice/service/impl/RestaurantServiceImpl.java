package kevserbusrayildirim.restaurantservice.service.impl;

import kevserbusrayildirim.restaurantservice.entity.Restaurant;
import kevserbusrayildirim.restaurantservice.exception.ResourceNotFoundException;
import kevserbusrayildirim.restaurantservice.mapper.RestaurantMapper;
import kevserbusrayildirim.restaurantservice.dto.RestaurantDto;
import kevserbusrayildirim.restaurantservice.model.request.RecommendRequest;
import kevserbusrayildirim.restaurantservice.model.request.RestaurantRequest;
import kevserbusrayildirim.restaurantservice.model.response.RecommendResponse;
import kevserbusrayildirim.restaurantservice.model.response.RestaurantSolrResponse;
import kevserbusrayildirim.restaurantservice.repository.RestaurantRepository;
import kevserbusrayildirim.restaurantservice.service.RestaurantService;
import kevserbusrayildirim.restaurantservice.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private static final Logger logger = LoggerFactory.getLogger(RestaurantService.class);

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper){
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public RestaurantDto createRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant savedRestaurant = restaurantRepository.save(restaurantRequest.toEntity());
        logger.info("RestaurantServiceImpl: Create restaurant.");
        return restaurantMapper.restaurantToRestaurantDTO(savedRestaurant);
    }

    @Override
    public RestaurantSolrResponse getAllRestaurants() {
        Iterable<Restaurant> restaurantIterable =  restaurantRepository.findAll();
        RestaurantSolrResponse response = new RestaurantSolrResponse();
        for (Restaurant restaurant : restaurantIterable){
            response.getRestaurants().add(restaurant);
        }
        logger.info("RestaurantServiceImpl: Get all restaurants.");
        return response;
    }

    @Override
    public RecommendResponse recommendedRestaurants(RecommendRequest recommendRequest) {
        double userLatitude = Double.parseDouble(recommendRequest.getLatitude());
        double userLongitude = new BigDecimal(recommendRequest.getLongitude()).doubleValue();

        Iterable<Restaurant> allRestaurants = restaurantRepository.findAll();
        List<Restaurant> recommendedRestaurants = new ArrayList<>();

        for (Restaurant restaurant : allRestaurants) {
            if(restaurant.getLatitude() != null && restaurant.getLongitude() != null){
                double restaurantLatitude = Double.parseDouble(restaurant.getLatitude());
                double restaurantLongitude = Double.parseDouble(restaurant.getLongitude());
                double distance = Utils.calculateDistance(userLatitude, userLongitude, restaurantLatitude, restaurantLongitude);
                double restaurantScore = Utils.scaleRestaurantScore(restaurant);

                if (distance <= 10) {
                    double weightedScore = (0.7 * restaurantScore) + (0.3 * (1 / distance));
                    restaurant.setScore(String.valueOf(weightedScore));
                    recommendedRestaurants.add(restaurant);
                }
            }
        }

        recommendedRestaurants = recommendedRestaurants.stream()
                .filter(r -> !Double.isInfinite(Double.parseDouble(r.getScore())))
                .collect(Collectors.toList());

        recommendedRestaurants.sort((r1, r2) -> Double.compare(Double.parseDouble(r2.getScore()), Double.parseDouble(r1.getScore())));

        for (Restaurant restaurant : recommendedRestaurants) {
            double scaledScore = Utils.scaleRestaurantScore(restaurant);
            restaurant.setScore(String.valueOf(scaledScore));
        }

        List<Restaurant> top3Restaurants = recommendedRestaurants.stream()
                .limit(3)
                .collect(Collectors.toList());

        RecommendResponse recommendResponse = new RecommendResponse();
        recommendResponse.setRestaurants(top3Restaurants);
        logger.info("RestaurantServiceImpl: Recommended restaurants response.");
        return recommendResponse;
    }

    @Override
    public RestaurantDto updateRestaurant(String restaurantId, Restaurant restaurant) {
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));
        existingRestaurant.setId(restaurant.getId());
        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setAddress(restaurant.getAddress());
        existingRestaurant.setScore(restaurant.getScore());
        existingRestaurant.setLatitude(restaurant.getLatitude());
        existingRestaurant.setLongitude(restaurant.getLongitude());

        Restaurant updatedRestaurant = restaurantRepository.save(existingRestaurant);
        logger.info("RestaurantServiceImpl: Updated restaurant.");
        return restaurantMapper.restaurantToRestaurantDTO(updatedRestaurant);
    }
    @Override
    public void deleteRestaurant(String restaurantId) {
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + restaurantId));
        logger.info("RestaurantServiceImpl: Deleted restaurant.");
        restaurantRepository.delete(existingRestaurant);
    }
}
