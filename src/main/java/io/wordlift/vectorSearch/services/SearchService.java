package io.wordlift.vectorSearch.services;

import io.wordlift.vectorSearch.entities.Movie;
import io.wordlift.vectorSearch.itos.Search;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SearchService {
    Mono<List<Movie>> searchMovieRecommendations(Search search);
}
