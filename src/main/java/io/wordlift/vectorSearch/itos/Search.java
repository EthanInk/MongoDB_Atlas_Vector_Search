package io.wordlift.vectorSearch.itos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Search {
    private String text;
    private List<Double> embeddings;
    private List<String> genreIn;
    private List<String> genreNotIn;
    private Integer yearGreaterThan;
    private Integer yearLessThen;
    private Integer numCandidates;
    private Integer limit;
}
