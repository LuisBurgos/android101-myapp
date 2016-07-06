package mx.yellowme.myapp.moviedetail;

import android.util.Log;

import mx.yellowme.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by luisburgos on 7/5/16.
 */
public class MovieInteractor {

    private MovieApiService apiService;
    private final String TAG = "MOVIE";

    public MovieInteractor(MovieApiService apiService) {
        this.apiService = apiService;
    }

    public void getMovie(final MovieCallback callback, String id){

        Log.d(TAG, "GETTING MOVIES");

        Call<Movie> call = apiService.getMovie(id);
        Log.d(TAG, "ORIGINAL REQ: " + call.request().toString());

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "SUCCESS");
                    Movie movie = response.body();
                    callback.onMovieLoaded(movie);

                } else {
                    Log.d(TAG, response.raw().toString());
                    callback.onFail(response.message());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.printStackTrace();
                Log.e(TAG, t.getMessage());
                callback.onFail("Ha ocurrido un error");
            }
        });


    }

}
