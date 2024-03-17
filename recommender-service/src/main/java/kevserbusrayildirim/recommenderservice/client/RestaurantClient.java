package kevserbusrayildirim.recommenderservice.client;

import kevserbusrayildirim.recommenderservice.model.request.RecommendedRestaurantsRequest;
import kevserbusrayildirim.recommenderservice.model.response.RecommendedRestaurantsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "restaurant-service", url = "localhost:8085")
public interface RestaurantClient {
    @PostMapping("/restaurants")
    RecommendedRestaurantsResponse getAllRestaurantsByUserLocation(@RequestBody RecommendedRestaurantsRequest recommendedRestaurantsRequest);
}
