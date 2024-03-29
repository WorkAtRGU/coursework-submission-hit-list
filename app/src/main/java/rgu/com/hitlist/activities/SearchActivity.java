package rgu.com.hitlist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import rgu.com.hitlist.model.Media;
import rgu.com.hitlist.model.Movie;
import rgu.com.hitlist.adapter.MyRecyclerViewAdapter;
import rgu.com.hitlist.R;
import rgu.com.hitlist.model.People;
import rgu.com.hitlist.model.Tv;
import rgu.com.hitlist.tmdbApi.FetchApi;


public class SearchActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener, Response.Listener<String>, Response.ErrorListener {

    MyRecyclerViewAdapter adapter;
    List<Media> searchData;
    String query;
    String dataType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle(R.string.titleSearch);
        handleIntent(getIntent());
    }

    @Override
    public void onItemClick(View view, int position) {
        switch(this.dataType) {
            case "movie":
                Intent movieIntent = new Intent(this, FilmDescriptionActivity.class);
                movieIntent.putExtra("movie", searchData.get(position));
                startActivity(movieIntent);
                break;
            case "tv":
                Intent TvIntent = new Intent(this, TVDescriptionActivity.class);
                TvIntent.putExtra("tv", searchData.get(position));
                startActivity(TvIntent);
                break;
            case "person":
                Intent personIntent = new Intent(this, PeopleDescriptionActvity.class);
                personIntent.putExtra("people", searchData.get(position));
                startActivity(personIntent);
                break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionMovies:
                Toast.makeText(this, "Movies filter", Toast.LENGTH_SHORT).show();
                this.dataType = "movie";
                search();
                return true;
            case R.id.actionPeople:
                Toast.makeText(this, "People filter", Toast.LENGTH_SHORT).show();
                this.dataType = "person";
                search();
                return true;
            case R.id.actionTVShows:
                Toast.makeText(this, "TV Shows filter", Toast.LENGTH_SHORT).show();
                this.dataType = "tv";
                search();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
        Toast.makeText(this, "new intent", Toast.LENGTH_LONG).show();
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            setTitle(getString(R.string.titleSearchQuery, query));

            this.query = query;
            this.dataType = "movie";
            search();
        }
    }

    private void search() {
        FetchApi.Search(this.query, this, this.dataType, this, this);
    }

    @Override
    public void onResponse(String response) {
        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray results = jsonResponse.getJSONArray("results");

            switch(this.dataType) {
                case "movie":
                    searchData = new Gson().fromJson(results.toString(), new TypeToken<List<Movie>>(){}.getType());
                    break;
                case "tv":
                    searchData = new Gson().fromJson(results.toString(), new TypeToken<List<Tv>>(){}.getType());
                    break;
                case "person":
                    searchData = new Gson().fromJson(results.toString(), new TypeToken<List<People>>(){}.getType());
                    break;
            }


            if(searchData.size() == 0) {
                Toast.makeText(this, getString(R.string.toastNoResult), Toast.LENGTH_LONG).show();
            } /*else {
                Toast.makeText(this, getString(R.string.toastResult, String.valueOf(searchData.size())), Toast.LENGTH_LONG).show();
            }*/ // the api always returns 20 results

            RecyclerView recyclerView = findViewById(R.id.rvSearch);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new MyRecyclerViewAdapter(this, searchData);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);

        } catch (JSONException e) {
            Log.d("debug", "JSONException: " + e);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("debug", error.toString());
    }
}
