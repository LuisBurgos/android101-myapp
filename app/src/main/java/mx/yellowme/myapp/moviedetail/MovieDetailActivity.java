package mx.yellowme.myapp.moviedetail;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import mx.yellowme.model.Fields;
import mx.yellowme.model.Movie;
import mx.yellowme.myapp.R;
import mx.yellowme.myapp.movies.MoviesContract;
import mx.yellowme.util.Injection;
import mx.yellowme.util.Util;

public class MovieDetailActivity extends AppCompatActivity
        implements MovieDetailContract.View {

    public static final String EXTRA_MOVIE_ID = "MOVIE_ID";

    private ProgressDialog mProgressDialog;
    private MovieDetailContract.UserActionsListener mActionsListener;

    private TextView movieNameTextView;
    private TextView movieDescriptionTextView;
    private ImageView moviePhotoImageView;

    private String movieID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movieNameTextView = (TextView) findViewById(R.id.movieNameTextView);
        movieDescriptionTextView = (TextView) findViewById(R.id.movieDescriptionTextView);
        moviePhotoImageView = (ImageView) findViewById(R.id.moviePhotoImageView);

        mProgressDialog = Util.createModalProgressDialog(this);

        movieID = getMovieIDFromExtras(getIntent().getExtras());

        mActionsListener = new MoviePresenter(
                this, Injection.provideMovieInteractor(this)
        );
    }

    private String getMovieIDFromExtras(Bundle extras) {
        return extras.getString(EXTRA_MOVIE_ID);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActionsListener.loadMovieInformation(movieID);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void setProgressIndicator(boolean active) {
        if(active) {
            mProgressDialog.setMessage("Cargando pelicula");
            mProgressDialog.show();
        } else {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showMovie(Movie movie) {
        Fields movieFields = movie.getFields();

        movieNameTextView.setText(movieFields.getName());
        movieDescriptionTextView.setText(movieFields.getDescription());

        Picasso.with(this)
                .load(movieFields.getPhotos().get(0).getUrl())
                .into(moviePhotoImageView);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
