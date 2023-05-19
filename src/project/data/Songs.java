package project.data;

import project.utilities.SongData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Songs {
    private ArrayList<SongData> songsList;
    private LinkedList<String> albums;
    private LinkedList<String> artists;
    private LinkedList<String> genres;

    // Constructor
    public Songs() {
        songsList = new ArrayList<>();
        albums = new LinkedList<>();
        artists = new LinkedList<>();
        genres = new LinkedList<>();

        String filename = System.getProperty("user.dir") + "/assets/data.txt";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = reader.readLine()) != null) {

                String[] song = line.split(",");
                songsList.add(new SongData(song[0], song[1], song[2], song[3], song[4], song[5]));
                if (!albums.contains(song[1])) {
                    albums.add(song[1]);
                }
                if (!artists.contains(song[2])) {
                    artists.add(song[2]);
                }
                if (!genres.contains(song[3])) {
                    genres.add(song[3]);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<SongData> getSongs() {
        return songsList;
    }

    public LinkedList<String> getAlbums() {
        return albums;
    }

    public LinkedList<String> getArtists() {
        return artists;
    }

    public LinkedList<String> getGenres() {
        return genres;
    }

}
