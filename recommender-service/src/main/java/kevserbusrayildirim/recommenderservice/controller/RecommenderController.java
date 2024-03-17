package kevserbusrayildirim.recommenderservice.controller;

import kevserbusrayildirim.recommenderservice.model.request.RecommendedRestaurantsRequest;
import kevserbusrayildirim.recommenderservice.model.response.RecommendedRestaurantsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommend")
@Validated
public class RecommenderController {
    @Autowired
    RecommenderControllerContract recommenderControllerContract;

    private static final Logger logger = LoggerFactory.getLogger(RecommenderController.class);

    @PostMapping("")
    public RecommendedRestaurantsResponse getAllRestaurantsByUserLocation(@RequestBody RecommendedRestaurantsRequest request){
        logger.info("RecommenderController: getAllRestaurantsByUserLocation method called");
        return recommenderControllerContract.getAllRestaurantsByUserLocation(request);
    }
}
