package LowLevelDesign.DesignBookMyShow;

import LowLevelDesign.DesignBookMyShow.Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityTheatreMap;
    List<Theatre> allTheatres;

    TheatreController() {
        cityTheatreMap = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    void addTheatre(Theatre theatre , City city) {

        allTheatres.add(theatre);

        List<Theatre> theatres = cityTheatreMap.getOrDefault(city,new ArrayList<>());
        theatres.add(theatre);
        cityTheatreMap.put(city,theatres);
    }

    Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {

        // get all the theater of this city
        Map<Theatre, List<Show>> theatreShowMap = new HashMap<>();

        List<Theatre> theatres  = cityTheatreMap.get(city);

        // filter the theatres which run this movie
        for (Theatre theatre : theatres) {
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows  = theatre.getShows();

            for(Show show : shows) {
                if(show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreShowMap.put(theatre, givenMovieShows);
            }
        }
        return theatreShowMap;
    }

}
