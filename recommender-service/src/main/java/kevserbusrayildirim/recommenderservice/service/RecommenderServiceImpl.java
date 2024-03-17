package kevserbusrayildirim.recommenderservice.service;

import kevserbusrayildirim.recommenderservice.client.RestaurantClient;
import kevserbusrayildirim.recommenderservice.model.request.RecommendedRestaurantsRequest;
import kevserbusrayildirim.recommenderservice.model.response.RecommendedRestaurantsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommenderServiceImpl implements RecommenderService{

    private static final Logger logger = LoggerFactory.getLogger(RecommenderService.class);

    @Autowired
    RestaurantClient restaurantClient;

    @Override
    public RecommendedRestaurantsResponse getAllRestaurantsByUserLocation(RecommendedRestaurantsRequest request) {
        logger.info("RecommenderServiceImpl: Recommend restaurants based on user location.");
        return restaurantClient.getAllRestaurantsByUserLocation(request);
    }
}
