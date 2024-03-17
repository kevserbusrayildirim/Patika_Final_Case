package kevserbusrayildirim.restaurantservice.controller;


import kevserbusrayildirim.restaurantservice.controller.contract.RestaurantControllerContract;
import kevserbusrayildirim.restaurantservice.dto.RestaurantDto;
import kevserbusrayildirim.restaurantservice.entity.Restaurant;
import kevserbusrayildirim.restaurantservice.model.request.RecommendRequest;
import kevserbusrayildirim.restaurantservice.model.request.RestaurantRequest;
import kevserbusrayildirim.restaurantservice.model.response.RecommendResponse;
import kevserbusrayildirim.restaurantservice.model.response.RestaurantSolrResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantControllerContract restaurantControllerContract;
    private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    public RestaurantController(RestaurantControllerContract restaurantControllerContract){
        this.restaurantControllerContract = restaurantControllerContract;
    }

    @GetMapping("")
    public RestaurantSolrResponse getAllRestaurants(){
        logger.info("RestaurantController: getAllRestaurants method called");
        return restaurantControllerContract.getAllRestaurants();
    }

    @PostMapping("/create")
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        RestaurantDto createdRestaurant = restaurantControllerContract.createRestaurant(restaurantRequest);
        logger.info("RestaurantController: createRestaurant method called");
        return ResponseEntity.ok(createdRestaurant);
    }

    @PostMapping("")
    public RecommendResponse recommendedRestaurants(@RequestBody RecommendRequest recommendRequest) {
        logger.info("RestaurantController: recommendedRestaurants method called");
        return restaurantControllerContract.recommendedRestaurants(recommendRequest);
    }

    @PutMapping("/{restaurantId}/update")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable String restaurantId, @RequestBody Restaurant restaurant){
        RestaurantDto restaurantDto = restaurantControllerContract.updateRestaurant(restaurantId, restaurant);
        logger.info("RestaurantController: updateRestaurant method called");
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantDto);
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable String restaurantId) {
        restaurantControllerContract.deleteRestaurant(restaurantId);
        logger.info("RestaurantController: deleteRestaurant method called");
        return ResponseEntity.noContent().build();
    }



}
