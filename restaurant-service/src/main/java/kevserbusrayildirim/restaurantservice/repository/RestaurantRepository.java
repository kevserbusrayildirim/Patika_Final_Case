package kevserbusrayildirim.restaurantservice.repository;

import kevserbusrayildirim.restaurantservice.entity.Restaurant;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface RestaurantRepository extends SolrCrudRepository<Restaurant, String> {
}
