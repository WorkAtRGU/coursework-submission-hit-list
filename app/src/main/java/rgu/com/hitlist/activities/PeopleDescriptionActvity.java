package rgu.com.hitlist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import rgu.com.hitlist.R;
import rgu.com.hitlist.model.People;
import rgu.com.hitlist.model.Tv;
import rgu.com.hitlist.tmdbApi.DownloadImageTask;
import rgu.com.hitlist.tmdbApi.FetchApi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.Iterator;
import java.util.Map;

public class PeopleDescriptionActvity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener, View.OnClickListener{

    People person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_description_actvity);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();

        if(intent.getSerializableExtra("people") != null) {
            person = (People)intent.getSerializableExtra("people");
            Log.d("debug", person.toString());
            FetchApi.GetMedia(String.valueOf(person.getId()), this, "person", this, this); //need to code getPerson in fetch API
            Log.d("debug", person.toString());


        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //destroy the activity and show the one that started it
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onResponse(String response) {
        person = new Gson().fromJson(response, People.class);
        ProgressBar pbPeople = findViewById(R.id.pbPeople);

        TextView tvPeName = findViewById(R.id.tvPeName);
        TextView tvPeBiography = findViewById(R.id.tvPeBiography);
        TextView tvBirthday = findViewById(R.id.tvBirthday);
        TextView tvKnownForDepartment = findViewById(R.id.tvKnownforDepartment);
        TextView tvAKA = findViewById(R.id.tvPeAKA);
        ImageView ivPeProfile = findViewById(R.id.ivPeProfile);


        new DownloadImageTask(ivPeProfile, "w500", pbPeople).execute(person.getProfile_path());
        tvPeName.setText(person.getName());
        tvPeBiography.setText(person.getBiography());
        tvBirthday.setText(getString(R.string.tvDateofBirth) + " " + person.getBirthday());
        tvKnownForDepartment.setText(getString(R.string.tvKnownFor) + " " + person.getKnown_for_department());
        String list = new String();
        list = getString(R.string.tvAKA) + "\n " ;
        for(String s : person.getAlso_known_as()){
            list += s + "\n";
        }
        tvAKA.setText(list);


    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
