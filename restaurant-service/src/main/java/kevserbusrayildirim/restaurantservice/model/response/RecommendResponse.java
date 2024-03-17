package kevserbusrayildirim.restaurantservice.model.response;

import kevserbusrayildirim.restaurantservice.entity.Restaurant;

import java.util.List;

public class RecommendResponse {
    public List<Restaurant> restaurants;

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

}
