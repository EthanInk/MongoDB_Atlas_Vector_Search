package io.wordlift.vectorSearch.mappers;

import io.wordlift.vectorSearch.dtos.SearchRequest;
import io.wordlift.vectorSearch.itos.Search;
import org.springframework.stereotype.Service;

@Service
public class SearchMapperService implements SearchMapper {
    public Search fromDto(SearchRequest searchRequest) {
        return Search.builder()
                .text(searchRequest.getText())
                .embeddings(searchRequest.getEmbeddings())
                .genreIn(searchRequest.getGenreIn())
                .genreNotIn(searchRequest.getGenreNotIn())
                .yearLessThen(searchRequest.getYearLessThen())
                .yearGreaterThan(searchRequest.getYearGreaterThan())
                .numCandidates(searchRequest.getNumCandidates())
                .limit(searchRequest.getLimit())
                .build();
    }
}
