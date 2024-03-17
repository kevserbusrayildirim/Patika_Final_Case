package kevserbusrayildirim.restaurantservice.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name= "recommender-service", url = "localhost:8086")
public interface RecommenderServiceClient {

}
