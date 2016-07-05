package mx.yellowme.myapp.movies;

import java.util.List;

import mx.yellowme.model.Movie;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by luisburgos on 7/5/16.
 */
public class MoviesPresenter implements MoviesContract.UserActionsListener, MoviesCallback {

    private MoviesContract.View mView;
    private MoviesInteractor mInteractor;

    public MoviesPresenter(MoviesInteractor interactor, MoviesContract.View view) {
        this.mInteractor = checkNotNull(interactor);
        this.mView = checkNotNull(view);
    }

    @Override
    public void loadMovies(boolean forceUpdate) {
        mView.setProgressIndicator(true);
        if (forceUpdate) {
            //mInteractor.refreshData();
        }
        mInteractor.getMovies(this);
    }

    @Override
    public void openMovieDetail(Movie movie) {
        checkNotNull(movie);
        mView.showMovieDetailUI(movie.getId());
    }

    @Override
    public void onMoviesLoaded(List<Movie> movies) {
        mView.setProgressIndicator(false);

        if(movies != null && !movies.isEmpty()){
            mView.showMovies(movies);
        } else {
            mView.showErrorMessage("No hay películas para mostrar");
        }
    }

    @Override
    public void onFailedLoad() {
        mView.setProgressIndicator(false);
        mView.showErrorMessage("Ocurrió un error");
    }
}
