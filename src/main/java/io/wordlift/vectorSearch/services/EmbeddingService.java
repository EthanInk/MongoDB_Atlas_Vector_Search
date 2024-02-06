package io.wordlift.vectorSearch.services;

import reactor.core.publisher.Mono;

import java.util.List;

public interface EmbeddingService {
    Mono<List<Double>> getEmbeddingData(String text);
}
