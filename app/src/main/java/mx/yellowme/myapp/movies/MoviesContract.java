package mx.yellowme.myapp.movies;

import java.util.List;

import mx.yellowme.model.Movie;

/**
 * Created by luisburgos on 7/5/16.
 */
public interface MoviesContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showMovies(List<Movie> movies);

        void showMovieDetailUI(String id);

        void showErrorMessage(String message);

    }

    interface UserActionsListener {

        void loadMovies(boolean forceUpdate);

        void openMovieDetail(Movie movie);

    }

}
