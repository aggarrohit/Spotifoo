package project.utilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static project.utilities.Constants.*;

public class Utils {

    //Checks if the user has entered 0 to go to main menu
    public static boolean isMainInput(int inputNumber) {
        if (inputNumber == 0) {
            return true;
        }
        return false;
    }

    //checks if the song has mp3 extension
    public static boolean isValidSong(String songFileName) {

        String[] songFileStr = songFileName.split("\\.");
        if (songFileStr.length == 2 && songFileStr[1].equals("mp3")) {
            return true;
        }

        return false;
    }

    //Play the selected music in default music player and open the given image (if provided)
    public static boolean PlayMusic(SongData songData) {
        String musicFilePath = "./assets/songs/" + songData.getSongFile();
        String imageFilePath = "./assets/albums/" + songData.getImage();
        String defaultImageFilePath = "./assets/no-picture.png";

        File musicFile = new File(musicFilePath);
        File imageFile = new File(imageFilePath);

        if (!musicFile.exists()) {
            System.out.println("The specified music file does not exist.");
            return false;
        }

        if (!imageFile.exists()) {
            imageFile = new File(defaultImageFilePath);
        }

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(imageFile);
            desktop.open(musicFile);
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while trying to play the music file.");
            e.printStackTrace();
            return false;
        }
    }

    //Filter all songs according to selected album or genre or artist (filter type)
    public static ArrayList<SongData> FilterSongs(ArrayList<SongData> allSongsList, String filterString, String filterType) {
        ArrayList<SongData> filteredArrayList = new ArrayList<>();
        for (int j = 0; j < allSongsList.size(); j++) {
            SongData songData = allSongsList.get(j);
            if (filterType.equals(ALBUM)) {
                if (songData.getAlbum().equals(filterString)) {
                    filteredArrayList.add(songData);
                }
            } else if (filterType.equals(GENRE)) {
                if (songData.getGenre().equals(filterString)) {
                    filteredArrayList.add(songData);
                }
            } else if (filterType.equals(ARTIST)) {
                if (songData.getArtist().equals(filterString)) {
                    filteredArrayList.add(songData);
                }
            }


        }
        return filteredArrayList;
    }
}
