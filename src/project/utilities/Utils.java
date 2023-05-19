package project.utilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static project.utilities.Constants.*;

public class Utils {
    public static boolean isMainInput(int inputNumber) {
        if (inputNumber == 0) {
            return true;
        }
        return false;
    }

    public static boolean isValidSong(String songFileName) {

        String[] songFileStr = songFileName.split("\\.");
        if (songFileStr.length == 2 && songFileStr[1].equals("mp3")) {
            return true;
        }

        return false;
    }

    public static boolean PlayMusic(SongData songData) {
        String musicFilePath = "./assets/songs/" + songData.getSongFile();  // Replace with the actual path to your music file
        String imageFilePath = "./assets/albums/" + songData.getImage();  // Replace with the actual path to your music file
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
