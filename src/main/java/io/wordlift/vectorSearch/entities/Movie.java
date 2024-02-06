package io.wordlift.vectorSearch.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String title;
    private String plot;
    private ArrayList<String> genres;
    private Integer year;
    private Double score;
}
