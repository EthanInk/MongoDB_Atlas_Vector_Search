package io.wordlift.vectorSearch.mappers;

import io.wordlift.vectorSearch.dtos.MovieDto;
import io.wordlift.vectorSearch.entities.Movie;

import java.util.List;

public interface MovieMapper {
    MovieDto toDTO(Movie movie);
    List<MovieDto> toDTOList(List<Movie> movieList);
}
