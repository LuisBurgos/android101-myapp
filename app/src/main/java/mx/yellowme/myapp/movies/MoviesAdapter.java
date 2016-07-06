package mx.yellowme.myapp.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import mx.yellowme.model.Movie;
import mx.yellowme.myapp.R;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context mContext;
    private List<Movie> mMovies;
    private MoviesFragment.MovieItemListener mItemListener;

    public MoviesAdapter(Context context, List<Movie> notes, MoviesFragment.MovieItemListener itemListener) {
        setList(notes);
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View noteView = inflater.inflate(R.layout.fragment_email, parent, false);

        return new ViewHolder(noteView, mItemListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        final Movie movie = mMovies.get(position);

        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.onMovieClick(movie);
            }
        });
        viewHolder.mContentView.setText(movie.getFields().getName());

        if(movie.getFields().getPhotos().size()>0){
            Picasso.with(mContext)
                    .load(movie.getFields().getPhotos().get(0).getUrl())
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .networkPolicy(NetworkPolicy.NO_CACHE)
                    .into(viewHolder.imageViewPic);
        }

    }

    public void replaceData(List<Movie> notes) {
        setList(notes);
        notifyDataSetChanged();
    }

    private void setList(List<Movie> notes) {
        mMovies = checkNotNull(notes);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public Movie getItem(int position) {
        return mMovies.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final ImageView imageViewPic;
        public final TextView mContentView;
        private MoviesFragment.MovieItemListener mListener;

        public ViewHolder(View view, MoviesFragment.MovieItemListener listener) {
            super(view);
            mView = view;
            mItemListener = listener;
            imageViewPic = (ImageView) view.findViewById(R.id.imageViewPic);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
