package nhn.rookieHAMATF.ryungjinkim_movie.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nhn.rookieHAMATF.ryungjinkim_movie.dto.ReviewDTO;
import nhn.rookieHAMATF.ryungjinkim_movie.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {
    private  final ReviewService reviewService;

    @GetMapping("/{mno}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("mno") Long mno){
        log.info("------list------");
        log.info("mno: " + mno);

        List<ReviewDTO> reviewDTOList = reviewService.getListOfMovie(mno);
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    @PostMapping("/{mno}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO movieReviewDTO){
        log.info("-------add MovieReview------");
        log.info("reviewDTO: " + movieReviewDTO);

        Long reviewNum = reviewService.register(movieReviewDTO);
        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }

    @PutMapping("/{mno}/{reviewNum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewNum, @RequestBody ReviewDTO movieReviewDTO){
        log.info("-------modify MovieReview------");
        log.info("reviewDTO: " + movieReviewDTO);

        reviewService.modify(movieReviewDTO);
        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }

    @DeleteMapping("/{mno}/{reviewNum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long reviewNum){
        log.info("-------remove MovieReview------");
        log.info("reviewNum: " + reviewNum);

        reviewService.remove(reviewNum);
        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }
}
