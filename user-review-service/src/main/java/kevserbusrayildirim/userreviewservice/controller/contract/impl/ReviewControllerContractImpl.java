package kevserbusrayildirim.userreviewservice.controller.contract.impl;


import kevserbusrayildirim.userreviewservice.controller.contract.ReviewControllerContract;

import kevserbusrayildirim.userreviewservice.dto.ReviewDto;
import kevserbusrayildirim.userreviewservice.entity.Review;
import kevserbusrayildirim.userreviewservice.model.request.ReviewRequest;
import kevserbusrayildirim.userreviewservice.model.request.ReviewUpdateRequest;
import kevserbusrayildirim.userreviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ReviewControllerContractImpl implements ReviewControllerContract {

    @Autowired
    private ReviewService reviewService;

    @Override
    public ReviewDto addReview(ReviewRequest request) {
        return reviewService.createReview(request);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @Override
    public List<ReviewDto> getAllReviewsByUserID(Long userId) {
        List<ReviewDto> reviews = reviewService.getAllReviewsByUserID(userId);
        return reviews;
    }
    @Override
    public void deleteReview(Long id) {
        reviewService.deleteReview(id);
    }

    @Override
    public ReviewDto updateReview(Long reviewId, ReviewUpdateRequest request) {
        return reviewService.updateReview(reviewId, request);
    }
}
