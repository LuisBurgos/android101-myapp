package mx.yellowme.myapp.movies;

import java.util.List;

import mx.yellowme.model.Movie;

public interface MoviesCallback {

    void onMoviesLoaded(List<Movie> movies);

    void onFailedLoad();

}