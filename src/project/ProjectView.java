package project;

import project.utilities.SongData;

import java.util.ArrayList;
import java.util.LinkedList;

public class ProjectView {

    public ProjectView() {
        showMainMenu();
    }

    public void showMainMenu() {
        System.out.println("Please choose an option!");
        System.out.println("[1] PLAY A SONG");
        System.out.println("[2] FILTER BY ARTIST");
        System.out.println("[3] FILTER BY ALBUM");
        System.out.println("[4] FILTER BY GENRE");
        System.out.println("[5] SEARCH SONG");

        showEnterMainMenuOption();
    }

    public void showSongList(ArrayList<SongData> arrayList) {

        for (int i = 0; i < arrayList.size(); i++) {
            SongData songData = arrayList.get(i);
            System.out.println("[" + (i + 1) + "] " + songData.getSongName() + " (" + songData.getAlbum() + ")");
        }

        printGoToMainMenuOption();

    }

    public void showFilterList(LinkedList<String> filterOptions, String filterType) {

        for (int i = 0; i < filterOptions.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + filterOptions.get(i));
        }
        printGoToMainMenuOption();
        System.out.printf("Please enter " + filterType + " number : ");

    }

    public void showSearchSongOption() {
        System.out.printf("Please enter song to search : ");
    }

    public void printGoToMainMenuOption() {
        System.out.println("[0] Go to Main List");
    }

    public void showEnterSongNumber() {
        System.out.printf("Enter the number of song you wan't to play : ");
    }

    public void showEnterSomethingValid() {
        System.out.printf("Please enter something valid!");
    }

    public void showCannotPlayThisSong() {
        System.out.println("This song cannot be played, please choose different one!!");
    }

    public void showWrongInput() {
        System.out.println("Wrong Input!!");
    }

    public void showEnterNumberBetween(int from, int to) {
        System.out.printf("Please enter number between " + from + " & " + to + " : ");
    }

    public void showNoMatchingSongFound() {
        System.out.println("No Matching song found!");
    }

    public void showEnterMainMenuOption() {
        System.out.printf("Please enter between 1 to 5 : ");
    }

    public void showMusicPlaying() {
        System.out.printf("Music is playing, play new song : ");
    }
}
