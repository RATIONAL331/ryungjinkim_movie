package nhn.rookieHAMATF.ryungjinkim_movie.repository;

import nhn.rookieHAMATF.ryungjinkim_movie.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
