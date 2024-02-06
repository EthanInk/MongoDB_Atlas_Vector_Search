package io.wordlift.vectorSearch.services;

import io.wordlift.vectorSearch.Repository.MovieRepository;
import io.wordlift.vectorSearch.entities.Movie;
import io.wordlift.vectorSearch.itos.Search;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class VectorSearchService implements SearchService {

    private final EmbeddingService embeddingService;
    private final MovieRepository movieRepository;

    @Override
    public Mono<List<Movie>> searchMovieRecommendations(Search search) {
        if (Objects.isNull(search.getEmbeddings())) {
            return embeddingService.getEmbeddingData(search.getText())
                    .flatMap(embeddings -> {
                        search.setEmbeddings(embeddings);
                        return movieRepository.getMovies(search).collectList();
                    });
        } else {
            return movieRepository.getMovies(search).collectList();
        }
    }

}
