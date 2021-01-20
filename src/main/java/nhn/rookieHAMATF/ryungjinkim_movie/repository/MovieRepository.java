package nhn.rookieHAMATF.ryungjinkim_movie.repository;

import nhn.rookieHAMATF.ryungjinkim_movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
