package rgu.com.hitlist.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Tv extends Media implements Serializable {
    private List<Map<String, Object>> created_by;
    private List<Integer> episode_run_time;
    private String first_air_date;
    private boolean in_production;
    private List<String> languages;
    private String last_air_date;
    private Map<String, Object> last_episode_to_air;
    private String name;
    private Map<String, Object> next_episode_to_air;
    private List<Map<String, Object>> networks;
    private int number_of_episodes;
    private int number_of_seasons;
    private List<String> origin_country;
    private String original_name;
    private List<Map<String, Object>> seasons;
    private String type;
    private String status;
    private float vote_average;
    private int vote_count;
    private String backdrop_path;
    private List<Map<String, String>> genres;
    private String original_language;
    private String overview;
    private List<Map<String, String>> production_companies;

    public Tv(long id, String title, float popularity, String poster_path) {
        super(id, popularity, poster_path);
        this.name = title;
    }


    @Override
    public String toString() {
        return "Tv{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<Map<String, Object>> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(List<Map<String, Object>> created_by) {
        this.created_by = created_by;
    }

    public List<Integer> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(List<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public boolean isIn_production() {
        return in_production;
    }

    public void setIn_production(boolean in_production) {
        this.in_production = in_production;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public Map<String, Object> getLast_episode_to_air() {
        return last_episode_to_air;
    }

    public void setLast_episode_to_air(Map<String, Object> last_episode_to_air) {
        this.last_episode_to_air = last_episode_to_air;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getNext_episode_to_air() {
        return next_episode_to_air;
    }

    public void setNext_episode_to_air(Map<String, Object> next_episode_to_air) {
        this.next_episode_to_air = next_episode_to_air;
    }

    public List<Map<String, Object>> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Map<String, Object>> networks) {
        this.networks = networks;
    }

    public int getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(int number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public int getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(int number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public List<Map<String, Object>> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Map<String, Object>> seasons) {
        this.seasons = seasons;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Map<String, String>> getGenres() {
        return genres;
    }

    public void setGenres(List<Map<String, String>> genres) {
        this.genres = genres;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
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
}
