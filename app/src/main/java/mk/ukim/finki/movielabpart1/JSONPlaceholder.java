package mk.ukim.finki.movielabpart1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholder {

    @GET("moviesAPI.json")
    Call<List<Movie>> getMovies();
}
