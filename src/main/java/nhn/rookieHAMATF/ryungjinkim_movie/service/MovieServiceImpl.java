package nhn.rookieHAMATF.ryungjinkim_movie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nhn.rookieHAMATF.ryungjinkim_movie.dto.MovieDTO;
import nhn.rookieHAMATF.ryungjinkim_movie.entity.Movie;
import nhn.rookieHAMATF.ryungjinkim_movie.entity.MovieImage;
import nhn.rookieHAMATF.ryungjinkim_movie.repository.MovieImageRepository;
import nhn.rookieHAMATF.ryungjinkim_movie.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;
    private final MovieImageRepository imageRepository;

    @Override
    @Transactional
    public Long register(MovieDTO movieDTO){
        Map<String, Object> entityMap = dtoToEntity(movieDTO);
        Movie movie = (Movie)entityMap.get("movie");
        List<MovieImage> movieImageList = (List<MovieImage>)entityMap.get("imgList");

        movieImageList.forEach(movieImage ->{
            imageRepository.save(movieImage);
        });
        return movie.getMno();
    }
}
