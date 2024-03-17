package kevserbusrayildirim.recommenderservice.controller;

import kevserbusrayildirim.recommenderservice.model.request.RecommendedRestaurantsRequest;
import kevserbusrayildirim.recommenderservice.model.response.RecommendedRestaurantsResponse;

public interface RecommenderControllerContract {
     RecommendedRestaurantsResponse
            getAllRestaurantsByUserLocation(RecommendedRestaurantsRequest request);
}
