package mx.yellowme.util;

import android.content.Context;

import mx.yellowme.myapp.MyappApplication;
import mx.yellowme.myapp.movies.MoviesApiService;
import mx.yellowme.myapp.movies.MoviesInteractor;

/**
 * Created by luisburgos on 7/5/16.
 */
public class Injection {

    public static MoviesInteractor provideMoviesInteractor(Context context){
        return new MoviesInteractor(provideMoviesApiService(context));
    }

    public static MoviesApiService provideMoviesApiService(Context context){
        MyappApplication app = (MyappApplication) context.getApplicationContext();
        return app.getRetrofit().create(MoviesApiService.class);
    }

}
