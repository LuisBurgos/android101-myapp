package mx.yellowme.myapp.movies;

import java.util.List;

import mx.yellowme.model.Movie;

/**
 * Created by luisburgos on 7/5/16.
 */
public interface MoviesCallback {

    void onMoviesLoaded(List<Movie> movies);

    void onFailedLoad();

}
