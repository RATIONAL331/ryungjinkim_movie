package nhn.rookieHAMATF.ryungjinkim_movie.service;

import nhn.rookieHAMATF.ryungjinkim_movie.dto.ReviewDTO;
import nhn.rookieHAMATF.ryungjinkim_movie.entity.Member;
import nhn.rookieHAMATF.ryungjinkim_movie.entity.Movie;
import nhn.rookieHAMATF.ryungjinkim_movie.entity.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getListOfMovie(Long mno);

    Long register(ReviewDTO movieReviewDTO);
    void modify(ReviewDTO movieReviewDTO);
    void remove(Long reviewNum);

    default Review dtoToEntity(ReviewDTO movieReviewDTO){
        Review movieReview = Review.builder()
                .reviewNum(movieReviewDTO.getReviewNum())
                .movie(Movie.builder().mno(movieReviewDTO.getMno()).build())
                .member(Member.builder().mid(movieReviewDTO.getMid()).build())
                .grade(movieReviewDTO.getGrade())
                .text(movieReviewDTO.getText())
                .build();
        return movieReview;
    }

    default ReviewDTO entityToDTO(Review movieReview){
        ReviewDTO movieReviewDTO = ReviewDTO.builder()
                .reviewNum(movieReview.getReviewNum())
                .mno(movieReview.getMovie().getMno())
                .nickname(movieReview.getMember().getNickname())
                .email(movieReview.getMember().getEmail())
                .grade(movieReview.getGrade())
                .text(movieReview.getText())
                .regDate(movieReview.getRegDate())
                .modeDate(movieReview.getModDate())
                .build();
        return movieReviewDTO;
    }
}
