package io.wordlift.vectorSearch.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private String text;
    private List<Double> embeddings;
    private List<String> genreIn;
    private List<String> genreNotIn;
    private Integer yearGreaterThan;
    private Integer yearLessThen;
    private Integer numCandidates;
    private Integer limit;

}
