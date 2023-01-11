package mk.ukim.finki.movielabpart1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    JSONPlaceholder jsonPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://stojanchevski.github.io/MovieLabPart1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceholder = retrofit.create(JSONPlaceholder.class);

        Call<List<Movie>> call = jsonPlaceholder.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                }
                List<Movie> movieList = response.body();
                MovieAdapter movieAdapter = new MovieAdapter(MainActivity.this,movieList);
                recyclerView.setAdapter(movieAdapter);
                }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

}