package kevserbusrayildirim.userreviewservice.controller;

import kevserbusrayildirim.userreviewservice.controller.contract.ReviewControllerContract;
import kevserbusrayildirim.userreviewservice.dto.ReviewDto;
import kevserbusrayildirim.userreviewservice.entity.Review;
import kevserbusrayildirim.userreviewservice.model.request.ReviewRequest;
import kevserbusrayildirim.userreviewservice.model.request.ReviewUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Validated
public class ReviewController {

    @Autowired
    private ReviewControllerContract reviewControllerContract;

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @GetMapping("")
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviewList = reviewControllerContract.getAllReviews();
        logger.info("ReviewController: getAllReviews method called");
        return ResponseEntity.status(HttpStatus.OK).body(reviewList);
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewRequest request) {
        ReviewDto addedReview = reviewControllerContract.addReview(request);
        logger.info("ReviewController: addReview method called");
        return ResponseEntity.status(HttpStatus.CREATED).body(addedReview);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<ReviewDto>> getAllReviewsByUserID(@PathVariable Long userId) {
        List<ReviewDto> allReviews = reviewControllerContract.getAllReviewsByUserID(userId);
        logger.info("ReviewController: getAllReviewsByUserID method called");
        return ResponseEntity.status(HttpStatus.CREATED).body(allReviews);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewControllerContract.deleteReview(reviewId);
        logger.info("ReviewController: deleteReview method called");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long reviewId, @RequestBody ReviewUpdateRequest request) {
        ReviewDto updatedReview = reviewControllerContract.updateReview(reviewId,request);
        logger.info("ReviewController: updateReview method called");
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedReview);
    }

}

