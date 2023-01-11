package mk.ukim.finki.movielabpart1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    List<Movie> movieList;
    Context context;

    public MovieAdapter(Context context , List<Movie> movies){
        this.context = context;
        movieList = movies;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new MovieViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.id.setText("id : " + movie.getId());
        holder.title.setText("movieTitle : " + movie.getTitle());
        holder.director.setText("director :" + movie.getDirector());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView id , title , director;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_tv);
            id = itemView.findViewById(R.id.id_tv);
            director = itemView.findViewById(R.id.director_tv);

        }
    }
}
