package kevserbusrayildirim.userreviewservice.ReviewTest.ServiceTest;

import kevserbusrayildirim.userreviewservice.dto.ReviewDto;
import kevserbusrayildirim.userreviewservice.dto.UserDto;
import kevserbusrayildirim.userreviewservice.entity.Review;
import kevserbusrayildirim.userreviewservice.entity.Score;
import kevserbusrayildirim.userreviewservice.mapper.ReviewMapper;
import kevserbusrayildirim.userreviewservice.mapper.UserMapper;
import kevserbusrayildirim.userreviewservice.model.request.ReviewRequest;
import kevserbusrayildirim.userreviewservice.model.request.ReviewUpdateRequest;
import kevserbusrayildirim.userreviewservice.repository.ReviewRepository;
import kevserbusrayildirim.userreviewservice.service.UserService;
import kevserbusrayildirim.userreviewservice.service.impl.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    private Review review;
    private ReviewRequest reviewRequest;
    private ReviewUpdateRequest reviewUpdateRequest;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        review = new Review();
        review.setId(1L);
        review.setText("Great restaurant!");
        review.setScore(Score.FOUR);
        review.setRestaurantId(1L);

        reviewRequest = new ReviewRequest();
        reviewRequest.setText("Great restaurant!");
        reviewRequest.setScore(Score.FOUR);
        reviewRequest.setUserId(1L);
        reviewRequest.setRestaurantId(2L);

        reviewUpdateRequest = new ReviewUpdateRequest();
        reviewUpdateRequest.setText("Amazing restaurant!");
        reviewUpdateRequest.setScore(Score.FOUR);

        userDto = new UserDto();
        userDto.setId(1L);
        userDto.setName("testUser");
    }


    @Test
    void testDeleteReview() {
        assertDoesNotThrow(() -> reviewService.deleteReview(1L));

        verify(reviewRepository, times(1)).deleteById(1L);
    }


    @Test
    void testGetAllReviews() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(review);
        when(reviewRepository.findAll()).thenReturn(reviews);

        List<Review> retrievedReviews = reviewService.getAllReviews();

        assertNotNull(retrievedReviews);
        assertEquals(reviews.size(), retrievedReviews.size());
    }

}

