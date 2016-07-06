package mx.yellowme.myapp.moviedetail;

import mx.yellowme.model.Movie;

/**
 * Created by luisburgos on 7/5/16.
 */
public interface MovieDetailContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showMovie(Movie movie);

        void showErrorMessage(String message);
    }

    interface UserActionsListener {

        void loadMovieInformation(String movieID);

    }


}
