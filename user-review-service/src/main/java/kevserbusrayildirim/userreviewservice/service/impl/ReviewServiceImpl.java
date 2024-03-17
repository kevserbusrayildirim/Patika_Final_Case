package kevserbusrayildirim.userreviewservice.service.impl;

import kevserbusrayildirim.userreviewservice.dto.UserDto;
import kevserbusrayildirim.userreviewservice.entity.User;
import kevserbusrayildirim.userreviewservice.exception.ResourceNotFoundException;
import kevserbusrayildirim.userreviewservice.dto.ReviewDto;
import kevserbusrayildirim.userreviewservice.entity.Review;
import kevserbusrayildirim.userreviewservice.mapper.ReviewMapper;
import kevserbusrayildirim.userreviewservice.mapper.UserMapper;
import kevserbusrayildirim.userreviewservice.model.request.ReviewRequest;
import kevserbusrayildirim.userreviewservice.model.request.ReviewUpdateRequest;
import kevserbusrayildirim.userreviewservice.repository.ReviewRepository;
import kevserbusrayildirim.userreviewservice.service.ReviewService;
import kevserbusrayildirim.userreviewservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private UserService userService;

    @Override
    public ReviewDto createReview(ReviewRequest request) {
        Review review = new Review();
        UserDto userDto = userService.getUserById(request.getUserId());
        if (userDto == null) {
            throw new IllegalArgumentException("User with ID " + request.getUserId() + " does not exist");
        }
        User user = userMapper.userDtoToUserEntity(userDto);
        review.setText(request.getText());
        review.setScore(request.getScore());
        review.setUser(user);
        review.setRestaurantId(request.getRestaurantId());
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.reviewToDto(savedReview);
    }

    @Override
    public ReviewDto updateReview(Long reviewId, ReviewUpdateRequest review) {
        Review foundedReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));

        foundedReview.setText(review.getText());
        foundedReview.setScore(review.getScore());

        Review updatedReview = reviewRepository.updateReviewById(reviewId,review.getText(), review.getScore());
        return reviewMapper.reviewToDto(updatedReview);
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public ReviewDto getReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
        return reviewMapper.reviewToDto(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<ReviewDto> getAllReviewsByUserID(Long userId) {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .filter(review -> review.getUser().getId().equals(userId))
                .map(reviewMapper::reviewToDto)
                .collect(Collectors.toList());
    }

}
