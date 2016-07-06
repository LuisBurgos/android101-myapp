package mx.yellowme.myapp.moviedetail;

import android.support.annotation.NonNull;

import mx.yellowme.model.Movie;
import mx.yellowme.myapp.movies.MoviesContract;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by luisburgos on 7/5/16.
 */
public class MoviePresenter implements
        MovieDetailContract.UserActionsListener,
        MovieCallback {

    private MovieDetailContract.View mView;
    private MovieInteractor mInteractor;

    public MoviePresenter(
            @NonNull MovieDetailContract.View view,
            @NonNull MovieInteractor interactor
    ) {
        mView = checkNotNull(view);
        mInteractor = checkNotNull(interactor);
    }

    @Override
    public void loadMovieInformation(String movieID) {

        mView.setProgressIndicator(true);

        mInteractor.getMovie(this, movieID);

    }

    @Override
    public void onMovieLoaded(Movie movie) {
        mView.setProgressIndicator(false);
        mView.showMovie(movie);
    }

    @Override
    public void onFail(String cause) {
        mView.setProgressIndicator(false);
        mView.showErrorMessage(cause);

    }
}
