package kevserbusrayildirim.restaurantservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;
import java.util.UUID;


@SolrDocument(collection = "n11-restaurants")
public class Restaurant {
    @Indexed(name = "id", type = "string")
    public String id = UUID.randomUUID().toString();

    @Indexed(name = "name", type = "string")
    public String name;

    @Indexed(name = "address", type = "string")
    public String address;

    @Indexed(name = "score", type = "double")
    public String score;

    @Indexed(name = "latitude", type = "string")
    public String latitude;

    @Indexed(name = "longitude", type = "string")
    public String longitude;

    public Restaurant(){

    }
    public Restaurant(String id, String name, String address, String latitude, String longitude){
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
