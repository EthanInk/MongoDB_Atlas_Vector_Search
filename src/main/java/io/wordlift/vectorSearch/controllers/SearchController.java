package io.wordlift.vectorSearch.controllers;

import io.wordlift.vectorSearch.dtos.MovieDto;
import io.wordlift.vectorSearch.dtos.SearchRequest;
import io.wordlift.vectorSearch.itos.Search;
import io.wordlift.vectorSearch.mappers.MovieMapper;
import io.wordlift.vectorSearch.mappers.SearchMapper;
import io.wordlift.vectorSearch.services.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/v1/search")
@AllArgsConstructor
public class SearchController {

    private final SearchService searchService;
    private final SearchMapper searchMapper;
    private final MovieMapper movieMapper;

    @PostMapping()
    public Mono<List<MovieDto>> performSearch(@RequestBody SearchRequest searchRequest) {
        Search search = searchMapper.fromDto(searchRequest);
        return searchService.searchMovieRecommendations(search).map(movieMapper::toDTOList);
    }

}
