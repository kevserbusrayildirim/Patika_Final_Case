package kevserbusrayildirim.restaurantservice.service;



import kevserbusrayildirim.restaurantservice.dto.RestaurantDto;
import kevserbusrayildirim.restaurantservice.entity.Restaurant;
import kevserbusrayildirim.restaurantservice.model.request.RecommendRequest;
import kevserbusrayildirim.restaurantservice.model.request.RestaurantRequest;
import kevserbusrayildirim.restaurantservice.model.response.RecommendResponse;
import kevserbusrayildirim.restaurantservice.model.response.RestaurantSolrResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantDto createRestaurant(RestaurantRequest restaurantRequest);
    RestaurantSolrResponse getAllRestaurants();
    RecommendResponse recommendedRestaurants(RecommendRequest recommendRequest);
    RestaurantDto updateRestaurant(String restaurantId, Restaurant restaurant);
    void deleteRestaurant(String restaurantId);
}
