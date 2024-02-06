package io.wordlift.vectorSearch.Repository;

import io.wordlift.vectorSearch.entities.Movie;
import io.wordlift.vectorSearch.itos.Search;
import reactor.core.publisher.Flux;

public interface MongoDBVectorMovieRepository {
    Flux<Movie> getMovies(Search search);
}
