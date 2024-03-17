package kevserbusrayildirim.restaurantservice.model.request;

import kevserbusrayildirim.restaurantservice.entity.Restaurant;

public class RestaurantRequest {
    public String name;
    public String address;
    public String score;
    public String latitude;
    public String longitude;

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

    public Restaurant toEntity(){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(this.getName());
        restaurant.setAddress(this.getAddress());
        restaurant.setScore(this.getScore());
        restaurant.setLatitude(this.getLatitude());
        restaurant.setLongitude(this.getLongitude());
        return restaurant;
    }
}
