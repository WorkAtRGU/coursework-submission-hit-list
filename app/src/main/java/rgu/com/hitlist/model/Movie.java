package rgu.com.hitlist.model;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class Movie extends Media implements Serializable {
    private boolean adult;
    private String backdrop_path;
    private Map<String, String> belongs_to_collection;
    private long budget;
    private List<Map<String, String>> genres;
    //private String homepage;
    //private long id;
    private String imdb_id;
    //private String original_language;
    private String original_title;
    private String overview;
    //private float popularity;
    //private String poster_path;
    private List<Map<String, String>> production_companies;
    private List<Map<String, String>> production_countries;
    private String release_date;
    private long revenue;
    private int runtime;
    private List<Map<String, String>> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private float vote_average;
    private int vote_count;

    public Movie(long id, String title, float popularity, String poster_path) {
        super(id, popularity, poster_path);
        this.title = title;
    }



    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                '}';
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Map<String, String> getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(Map<String, String> belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public List<Map<String, String>> getGenres() {
        return genres;
    }

    public void setGenres(List<Map<String, String>> genres) {
        this.genres = genres;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Map<String, String>> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Map<String, String>> production_companies) {
        this.production_companies = production_companies;
    }

    public List<Map<String, String>> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<Map<String, String>> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<Map<String, String>> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<Map<String, String>> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
