package nhn.rookieHAMATF.ryungjinkim_movie.repository;

import nhn.rookieHAMATF.ryungjinkim_movie.entity.Member;
import nhn.rookieHAMATF.ryungjinkim_movie.entity.Movie;
import nhn.rookieHAMATF.ryungjinkim_movie.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);


    @Modifying
    @Query("delete from Review mr where mr.member = :member")
    void deleteByMember(Member member);
}
