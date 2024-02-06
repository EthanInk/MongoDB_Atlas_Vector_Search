package io.wordlift.vectorSearch.mappers;

import io.wordlift.vectorSearch.dtos.SearchRequest;
import io.wordlift.vectorSearch.itos.Search;

public interface SearchMapper {
    Search fromDto(SearchRequest searchRequest);
}
