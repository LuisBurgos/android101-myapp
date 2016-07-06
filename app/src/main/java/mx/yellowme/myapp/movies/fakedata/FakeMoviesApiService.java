package mx.yellowme.myapp.movies.fakedata;

import android.support.v4.util.ArrayMap;

import java.util.ArrayList;

import mx.yellowme.model.Fields;
import mx.yellowme.model.Movie;
import mx.yellowme.model.Photo;

/**
 * Created by luisburgos on 7/5/16.
 */
public class FakeMoviesApiService {

    static {
        DATA = new ArrayMap(4);
        addMovie("11");
        addMovie("12");
        addMovie("13");
        addMovie("14");
        addMovie("15");
        addMovie("16");
        addMovie("17");
    }

    private final static ArrayMap<String, Movie> DATA;

    private static void addMovie(String id) {
        Movie newMovie = new Movie();
        Fields newMovieFields = new Fields();

        newMovieFields.setName("Película " + id);

        Photo photo = new Photo();
        photo.setUrl("http://lorempixel.com/200/200/sports/");
        ArrayList photos = new ArrayList<Photo>();
        photos.add(photo);

        newMovieFields.setPhotos(photos);

        newMovie.setId(id);
        newMovie.setFields(newMovieFields);
        DATA.put(id, newMovie);
    }

    /**
     * @return the Notes to show when starting the app.
     */
    public static ArrayMap<String, Movie> loadPersistentMovies() {
        return DATA;
    }

}