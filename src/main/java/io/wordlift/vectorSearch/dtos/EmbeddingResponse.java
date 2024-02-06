package io.wordlift.vectorSearch.dtos;

import lombok.Data;

import java.util.List;

@Data
public class EmbeddingResponse {
    private List<EmbeddingData> data;

    public List<Double> getEmbedding() {
        return data.get(0).getEmbedding();
    }
}
