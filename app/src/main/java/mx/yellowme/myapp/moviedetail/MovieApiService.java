package mx.yellowme.myapp.moviedetail;

import mx.yellowme.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by luisburgos on 7/5/16.
 */
public interface MovieApiService {

    @GET("Movies/{id}")
    Call<Movie> getMovie(@Path("id") String movieID);

}
