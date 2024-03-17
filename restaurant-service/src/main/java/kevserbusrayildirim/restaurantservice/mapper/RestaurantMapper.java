package kevserbusrayildirim.restaurantservice.mapper;


import kevserbusrayildirim.restaurantservice.dto.RestaurantDto;
import kevserbusrayildirim.restaurantservice.entity.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

   public RestaurantDto restaurantToRestaurantDTO(Restaurant restaurant){
       RestaurantDto restaurantDTO = new RestaurantDto();
       restaurantDTO.setId(restaurant.getId());
       restaurantDTO.setName(restaurant.getName());
       restaurantDTO.setAddress(restaurant.getAddress());
       restaurantDTO.setLatitude(restaurant.getLatitude());
       restaurantDTO.setLongitude(restaurant.getLongitude());
        return restaurantDTO;
    }

    public Restaurant restaurantDtoToEntity(RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setLatitude(restaurantDto.getLatitude());
        restaurant.setLongitude(restaurantDto.getLongitude());
        return restaurant;
    }
}
