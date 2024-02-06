package io.wordlift.vectorSearch.mappers;

import io.wordlift.vectorSearch.dtos.MovieDto;
import io.wordlift.vectorSearch.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieMapperService implements MovieMapper {
    public MovieDto toDTO(Movie movie) {
        return MovieDto.builder()
                .plot(movie.getPlot())
                .title(movie.getTitle())
                .genres(movie.getGenres())
                .year(movie.getYear())
                .score(movie.getScore())
                .build();
    }

    public List<MovieDto> toDTOList(List<Movie> movieList) {
        return movieList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
