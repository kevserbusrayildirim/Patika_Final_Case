package kevserbusrayildirim.restaurantservice.utils;

import kevserbusrayildirim.restaurantservice.entity.Restaurant;

public class Utils {
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance;
    }

    public static double scaleRestaurantScore(Restaurant restaurant) {
        double rating = Double.parseDouble(restaurant.getScore());
        double scaledScore = Math.min(5.0, rating); // Puanı 0 ile 5 arasında scale
        return scaledScore;
    }

}
