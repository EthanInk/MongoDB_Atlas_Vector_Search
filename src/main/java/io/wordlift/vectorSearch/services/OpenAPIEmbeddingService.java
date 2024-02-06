package io.wordlift.vectorSearch.services;

import io.wordlift.vectorSearch.Configuration.OpenAPIConfigProperties;
import io.wordlift.vectorSearch.dtos.EmbeddingResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class OpenAPIEmbeddingService implements EmbeddingService {

    private final OpenAPIConfigProperties openAPIConfigProperties;
    private WebClient webClient;

    public OpenAPIEmbeddingService(OpenAPIConfigProperties openAPIConfigProperties) {
        this.openAPIConfigProperties = openAPIConfigProperties;
    }


    @PostConstruct
    void init() {
        this.webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector())
                .baseUrl(openAPIConfigProperties.getUri())
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer " + openAPIConfigProperties.getKey())
                .build();
    }


    @Override
    public Mono<List<Double>> getEmbeddingData(String text) {
        Map<String, Object> body = Map.of(
                "model", "text-embedding-ada-002",
                "input", text
        );

        return webClient.post()
                .uri("/v1/embeddings")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(EmbeddingResponse.class)
                .map(EmbeddingResponse::getEmbedding);
    }
}
