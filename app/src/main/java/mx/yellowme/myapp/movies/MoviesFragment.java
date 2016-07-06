package mx.yellowme.myapp.movies;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.yellowme.fragment.ListFragment;
import mx.yellowme.fragment.MyEmailRecyclerViewAdapter;
import mx.yellowme.model.Movie;
import mx.yellowme.myapp.R;
import mx.yellowme.myapp.moviedetail.MovieDetailActivity;
import mx.yellowme.util.Injection;
import mx.yellowme.util.Util;

/**
 * Created by luisburgos on 7/5/16.
 */
public class MoviesFragment extends Fragment implements MoviesContract.View {

    private MoviesContract.UserActionsListener mActionsListener;
    private ProgressDialog mProgressDialog;
    private MoviesAdapter mAdapter;

    public MoviesFragment() {
        // Requires empty public constructor
    }

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new MoviesAdapter(getContext(), new ArrayList<Movie>(0), new MovieItemListener() {
            @Override
            public void onMovieClick(Movie clickedMovie) {
                mActionsListener.openMovieDetail(clickedMovie);
            }
        });
        mActionsListener = new MoviesPresenter(
                Injection.provideMoviesInteractor(getContext()), this
        );
        mProgressDialog = Util.createModalProgressDialog(getActivity());
    }


    @Override
    public void onResume() {
        super.onResume();
        mActionsListener.loadMovies(false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_email_list, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.list);
        recyclerView.setAdapter(mAdapter);

        int numColumns = 2;

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numColumns));


        return root;
    }

    @Override
    public void setProgressIndicator(boolean active) {
        if(active) {
            mProgressDialog.setMessage("Cargando peliculas");
            mProgressDialog.show();
        } else {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showMovies(List<Movie> movies) {
        mAdapter.replaceData(movies);
    }

    @Override
    public void showMovieDetailUI(String id) {
        showMessage("Abriendo película con ID: " + id);
        Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_ID, id);
        startActivity(intent);
    }

    @Override
    public void showErrorMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_INDEFINITE).show();
    }

    private void showMessage(String message){
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

    public interface MovieItemListener {
        void onMovieClick(Movie clickedMovie);
    }

}
