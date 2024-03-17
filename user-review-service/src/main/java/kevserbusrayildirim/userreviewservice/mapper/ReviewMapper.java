package kevserbusrayildirim.userreviewservice.mapper;

import kevserbusrayildirim.userreviewservice.dto.ReviewDto;
import kevserbusrayildirim.userreviewservice.entity.Review;

import org.springframework.stereotype.Component;


@Component
public class ReviewMapper {

    public ReviewDto reviewToDto(Review review) {
        ReviewDto reviewDTO = new ReviewDto();
        reviewDTO.setId(review.getId());
        reviewDTO.setText(review.getText());
        reviewDTO.setScore(review.getScore());
        reviewDTO.setUser(review.getUser());
        reviewDTO.setRestaurantId(review.getRestaurantId());
        return reviewDTO;
    }

    public Review reviewDtoToEntity(ReviewDto reviewDTO) {
        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setText(reviewDTO.getText());
        review.setScore(reviewDTO.getScore());
        return review;
    }


}
