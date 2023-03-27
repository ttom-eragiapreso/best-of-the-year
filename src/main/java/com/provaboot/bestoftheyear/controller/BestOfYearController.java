package com.provaboot.bestoftheyear.controller;

import com.provaboot.bestoftheyear.movie.Movie;
import com.provaboot.bestoftheyear.song.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BestOfYearController {

    @GetMapping
    public String getHome(Model model){
        model.addAttribute("name", "Enrico");
        return "home";
    }
    @GetMapping("/songs")
    public String getBestSongs(Model model){

        List<Song> bestSongs = listBestSongs();
        String output = "";
        for (Song s :
                bestSongs) {
            output+= s.getTitle() + ", ";
        }

        String result = output.substring(0, output.length() -2 );

        model.addAttribute("songs", result + ".");
        return "songs";
    }

    @GetMapping("/movies")
    public String getBestMovies(Model model){

        List<Movie> bestMovies = listBestMovies();
        String output = "";

        for (Movie m :
                bestMovies) {
            output+=m.getTitle() + ", ";
        }

        output = output.substring(0, output.length() -2);

        model.addAttribute("movies", output + ".");

        return "movies";
    }

    private List<Song> listBestSongs(){
        List<Song> bestSongs = new ArrayList<>();

        bestSongs.add(new Song(1, "Scar Tissue"));
        bestSongs.add(new Song(2, "Californication"));
        bestSongs.add(new Song(3, "Dani California"));
        bestSongs.add(new Song(4, "Can't Stop"));


        return bestSongs;
    }
    private List<Movie> listBestMovies(){
        List<Movie> bestMovies = new ArrayList<>();

        bestMovies.add(new Movie(1, "Toy Story"));
        bestMovies.add(new Movie(2, "Avatar"));
        bestMovies.add(new Movie(3, "The Gladiator"));
        bestMovies.add(new Movie(4, "Lord of the Rings"));


        return bestMovies;
    }
}
