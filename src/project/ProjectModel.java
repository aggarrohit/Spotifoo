package project;

import project.data.Songs;
import project.utilities.SongData;

import java.util.ArrayList;
import java.util.LinkedList;

public class ProjectModel {

    private ArrayList<SongData> songsList;
    private LinkedList<String> albums;
    private LinkedList<String> artists;
    private LinkedList<String> genres;

    private Songs songs;

    public ProjectModel() {
        songs = new Songs();
        songsList = songs.getSongs();
        albums = songs.getAlbums();
        artists = songs.getArtists();
        genres = songs.getGenres();
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
