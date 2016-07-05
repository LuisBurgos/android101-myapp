package mx.yellowme.myapp.movies;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;

import mx.yellowme.model.Movie;
import mx.yellowme.model.MoviesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by luisburgos on 7/5/16.
 */
public class MoviesInteractor {

    private final String TAG = "MOVIES";
    private MoviesApiService apiService;

    public MoviesInteractor(MoviesApiService apiService){
        this.apiService = apiService;
    }

    public void getMovies(final MoviesCallback callback) {

        Log.d(TAG, "GETTING MOVIES");

        /*Call<MoviesResponse> call = apiService.getMovies();
        Log.d(TAG, "ORIGINAL REQ: " + call.request().toString());

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "SUCCESS");
                    MoviesResponse moviesResponse = response.body();
                    callback.onMoviesLoaded(moviesResponse.getMovies());

                } else {
                    callback.onFailedLoad();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e(TAG, t.getMessage());
                callback.onFailedLoad();
            }
        });*/
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Movie> movies = new ArrayList<Movie>(FakeMoviesApiService.loadPersistentMovies().values());
                callback.onMoviesLoaded(movies);
            }
        }, 2500);
    }

}
