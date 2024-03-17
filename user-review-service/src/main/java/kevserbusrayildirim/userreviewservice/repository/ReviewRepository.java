package kevserbusrayildirim.userreviewservice.repository;

import kevserbusrayildirim.userreviewservice.entity.Review;
import kevserbusrayildirim.userreviewservice.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Review r SET r.text = :text , r.score = :score WHERE r.id = :reviewId")
    Review updateReviewById(Long reviewId, String text, Score score);

}
