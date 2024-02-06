package io.wordlift.vectorSearch.dtos;

import lombok.Data;

import java.util.List;

@Data
public class EmbeddingData {
    private List<Double> embedding;
}
