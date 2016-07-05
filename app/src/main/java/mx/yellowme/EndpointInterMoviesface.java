package mx.yellowme;

import mx.yellowme.model.MoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by javikin on 7/4/16.
 */
public interface EndpointInterMoviesface {

	@GET("Movies")
	Call<MoviesResponse> getMovies();
}
