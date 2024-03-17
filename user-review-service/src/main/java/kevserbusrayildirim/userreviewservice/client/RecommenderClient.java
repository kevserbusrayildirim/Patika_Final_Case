package kevserbusrayildirim.userreviewservice.client;

import kevserbusrayildirim.userreviewservice.model.request.RecommenderRequest;
import kevserbusrayildirim.userreviewservice.model.response.RecommenderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "recommender-service", url = "localhost:8086", configuration = FeignConfig.class)
public interface RecommenderClient {
    @PostMapping(value ="/recommend")
    RecommenderResponse getRecommendedRestaurantsByUserLocation(@RequestBody RecommenderRequest recommenderRequest);
}
