package mx.yellowme.myapp.moviedetail;

import mx.yellowme.model.Movie;

/**
 * Created by luisburgos on 7/5/16.
 */
public interface MovieCallback {

    void onMovieLoaded(Movie movie);

    void onFail(String cause);

}
