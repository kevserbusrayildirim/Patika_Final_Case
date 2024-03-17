package kevserbusrayildirim.userreviewservice.service;

import kevserbusrayildirim.userreviewservice.dto.ReviewDto;
import kevserbusrayildirim.userreviewservice.entity.Review;
import kevserbusrayildirim.userreviewservice.model.request.ReviewRequest;
import kevserbusrayildirim.userreviewservice.model.request.ReviewUpdateRequest;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(ReviewRequest request);
    ReviewDto updateReview(Long reviewId, ReviewUpdateRequest request);
    void deleteReview(Long reviewId);
    ReviewDto getReviewById(Long reviewId);
    List<Review> getAllReviews();
    List<ReviewDto> getAllReviewsByUserID(Long userId);
}
