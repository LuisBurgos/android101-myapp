package mx.yellowme.myapp.movies.fakedata;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import mx.yellowme.model.Movie;
import mx.yellowme.myapp.movies.MoviesApiService;
import mx.yellowme.myapp.movies.MoviesCallback;

/**
 * Created by luisburgos on 7/5/16.
 */
public class FakeMoviesInteractor {

    private final String TAG = "FAKEFAKEMOVIES";
    private MoviesApiService apiService;
    private long SERVICE_NETWORK_LATENCY = 2500;

    public FakeMoviesInteractor(MoviesApiService apiService) {
        this.apiService = apiService;
    }

    public void getMovies(final MoviesCallback callback) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                List<Movie> movies = new ArrayList<Movie>(
                        FakeMoviesApiService.loadPersistentMovies().values()
                );

                callback.onMoviesLoaded(movies);

            }
        }, SERVICE_NETWORK_LATENCY);

    }

}
