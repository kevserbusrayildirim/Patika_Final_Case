package kevserbusrayildirim.restaurantservice.controller.contract;

import kevserbusrayildirim.restaurantservice.entity.Restaurant;
import kevserbusrayildirim.restaurantservice.model.request.RecommendRequest;
import kevserbusrayildirim.restaurantservice.model.request.RestaurantRequest;
import kevserbusrayildirim.restaurantservice.model.response.RecommendResponse;
import kevserbusrayildirim.restaurantservice.dto.RestaurantDto;
import kevserbusrayildirim.restaurantservice.model.response.RestaurantSolrResponse;

public interface RestaurantControllerContract {
    RestaurantDto createRestaurant(RestaurantRequest restaurantRequest);
    RecommendResponse recommendedRestaurants(RecommendRequest recommendRequest);
    RestaurantSolrResponse getAllRestaurants();
    RestaurantDto updateRestaurant(String restaurantId, Restaurant restaurant);
    void deleteRestaurant(String reviewId);
}
