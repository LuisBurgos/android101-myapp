package mx.yellowme.myapp.movies;

import mx.yellowme.model.MoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApiService {

    @GET("Movies")
    Call<MoviesResponse> getMovies();

}