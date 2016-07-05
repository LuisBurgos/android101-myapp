package mx.yellowme.myapp.movies;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import mx.yellowme.model.MoviesResponse;
import mx.yellowme.myapp.MyappApplication;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        Call<MoviesResponse> call = apiService.getMovies();
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
        });
    }

}
