package io.wordlift.vectorSearch.Repository;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.search.VectorSearchOptions;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import io.wordlift.vectorSearch.Configuration.MongoDBConfigProperties;
import io.wordlift.vectorSearch.entities.Movie;
import io.wordlift.vectorSearch.itos.Search;
import lombok.AllArgsConstructor;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Aggregates.vectorSearch;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.search.SearchPath.fieldPath;

@AllArgsConstructor
@Repository
public class MovieRepository implements MongoDBVectorMovieRepository {
    private final MongoDatabase mongoDatabase;
    private final MongoDBConfigProperties mongoDBConfigProperties;

    @Override
    public Flux<Movie> getMovies(Search search) {
        int numCandidates = search.getNumCandidates();
        int limit = search.getLimit();
        List<String> genresNotInCriteria = search.getGenreNotIn();
        List<String> genresInCriteria = search.getGenreIn();
        Bson criteria = Filters.and(
                Filters.nin("genres", genresNotInCriteria),
                Filters.in("genres", genresInCriteria),
                Filters.gte("year", search.getYearGreaterThan()),
                Filters.lte("year", search.getYearLessThen())

        );
        VectorSearchOptions options = VectorSearchOptions.vectorSearchOptions().filter(criteria);

        List<Bson> pipeline = Arrays.asList(
                vectorSearch(
                        fieldPath("plot_embedding"),
                        search.getEmbeddings(),
                        mongoDBConfigProperties.getVector(),
                        numCandidates,
                        limit,
                        options),
                project(fields(metaVectorSearchScore("score"), include("plot", "title", "genres", "year")))
        );

        return Flux.from(getMovieCollection().aggregate(pipeline, Movie.class));

    }

    private MongoCollection<Movie> getMovieCollection() {
        return mongoDatabase.getCollection(mongoDBConfigProperties.getCollection(), Movie.class);
    }
}