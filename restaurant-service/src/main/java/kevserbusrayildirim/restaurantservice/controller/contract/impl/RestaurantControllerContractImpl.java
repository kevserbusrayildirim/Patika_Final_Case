package kevserbusrayildirim.restaurantservice.controller.contract.impl;

import kevserbusrayildirim.restaurantservice.controller.contract.RestaurantControllerContract;
import kevserbusrayildirim.restaurantservice.dto.RestaurantDto;
import kevserbusrayildirim.restaurantservice.entity.Restaurant;
import kevserbusrayildirim.restaurantservice.model.request.RecommendRequest;
import kevserbusrayildirim.restaurantservice.model.request.RestaurantRequest;
import kevserbusrayildirim.restaurantservice.model.response.RecommendResponse;
import kevserbusrayildirim.restaurantservice.model.response.RestaurantSolrResponse;
import kevserbusrayildirim.restaurantservice.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantControllerContractImpl implements RestaurantControllerContract {

    private final RestaurantService restaurantService;

    public RestaurantControllerContractImpl(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @Override
    public RestaurantDto createRestaurant(RestaurantRequest restaurantRequest) {
        return restaurantService.createRestaurant(restaurantRequest);
    }

    @Override
    public RecommendResponse recommendedRestaurants(RecommendRequest recommendRequest) {
        return restaurantService.recommendedRestaurants(recommendRequest);
    }

    @Override
    public RestaurantSolrResponse getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @Override
    public RestaurantDto updateRestaurant(String restaurantId, Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurantId, restaurant);
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}
