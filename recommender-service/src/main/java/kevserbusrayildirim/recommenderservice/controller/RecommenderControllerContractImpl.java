package kevserbusrayildirim.recommenderservice.controller;

import kevserbusrayildirim.recommenderservice.model.request.RecommendedRestaurantsRequest;
import kevserbusrayildirim.recommenderservice.model.response.RecommendedRestaurantsResponse;
import kevserbusrayildirim.recommenderservice.service.RecommenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RecommenderControllerContractImpl implements RecommenderControllerContract {
    @Autowired
    RecommenderService recommenderService;
    @Override
    public RecommendedRestaurantsResponse getAllRestaurantsByUserLocation(RecommendedRestaurantsRequest request) {
        return recommenderService.getAllRestaurantsByUserLocation(request);
    }
}
