package io.wordlift.vectorSearch.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class MovieDto {
    private final String title;
    private final String plot;
    private final ArrayList<String> genres;
    private final Integer year;
    private final Double score;
}
