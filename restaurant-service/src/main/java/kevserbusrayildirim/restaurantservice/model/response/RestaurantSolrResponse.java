package kevserbusrayildirim.restaurantservice.model.response;

import kevserbusrayildirim.restaurantservice.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSolrResponse {
    List<Restaurant> restaurants;

    public RestaurantSolrResponse() {
        this.restaurants = new ArrayList<>(); // Liste başlatılıyor
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
