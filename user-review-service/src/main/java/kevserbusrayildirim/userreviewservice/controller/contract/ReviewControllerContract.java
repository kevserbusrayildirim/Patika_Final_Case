package kevserbusrayildirim.userreviewservice.controller.contract;

import kevserbusrayildirim.userreviewservice.dto.ReviewDto;
import kevserbusrayildirim.userreviewservice.entity.Review;
import kevserbusrayildirim.userreviewservice.model.request.ReviewRequest;
import kevserbusrayildirim.userreviewservice.model.request.ReviewUpdateRequest;

import java.util.List;

public interface ReviewControllerContract {
    ReviewDto addReview(ReviewRequest request);
    List<ReviewDto> getAllReviewsByUserID(Long userId);
    void deleteReview(Long reviewId);
    ReviewDto updateReview(Long reviewId, ReviewUpdateRequest request);
    List<Review> getAllReviews();
}
