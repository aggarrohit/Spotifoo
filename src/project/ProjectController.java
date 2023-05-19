package project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import project.utilities.SongData;
import project.utilities.Utils;

import static project.utilities.Constants.*;

public class ProjectController {

    private final ProjectModel model;
    private final ProjectView view;
    private final Scanner scanner;

    public ProjectController(ProjectModel model, ProjectView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void catchMainMenuInput() {


        String inputString = scanner.nextLine();


        try {
            int inputNumber = Integer.parseInt(inputString);
            switch (inputNumber) {
                case 1:
                    view.showSongList(model.getSongs());
                    catchSongNumber(model.getSongs());
                    break;
                case 2:
                    view.showFilterList(model.getArtists(), ARTIST);
                    catchFilterNumber(model.getArtists(), ARTIST);
                    break;
                case 3:
                    view.showFilterList(model.getAlbums(), ALBUM);
                    catchFilterNumber(model.getAlbums(), ALBUM);
                    break;
                case 4:
                    view.showFilterList(model.getGenres(), GENRE);
                    catchFilterNumber(model.getGenres(), GENRE);
                    break;
                case 5:
                    view.showSearchSongOption();
                    catchSearchSongInput();
                    break;
                default:
                    view.showWrongInput();
                    view.showEnterMainMenuOption();
                    catchMainMenuInput();
                    break;
            }
        } catch (Exception e) {
            view.showWrongInput();
            view.showEnterMainMenuOption();
            catchMainMenuInput();
        }
    }

    public void catchSongNumber(ArrayList<SongData> songsList) {
        view.showEnterSongNumber();
        try {
            String x = scanner.nextLine();
            int i = Integer.parseInt(x);

            if (Utils.isMainInput(i)) {
                view.showMainMenu();
                catchMainMenuInput();
            } else if (i > 0 && i <= songsList.size()) {
                if (Utils.isValidSong(songsList.get(i - 1).getSongFile())) {
                    if (Utils.PlayMusic(songsList.get(i - 1))) {
                        view.showMusicPlaying();
                    } else {
                        view.showCannotPlayThisSong();
                    }
                } else {
                    view.showCannotPlayThisSong();
                }
                catchSongNumber(songsList);
            } else {
                view.showEnterNumberBetween(1, songsList.size());
                catchSongNumber(songsList);
            }


        } catch (Exception e) {
            view.showWrongInput();
            catchSongNumber(songsList);
        }
    }

    public void catchFilterNumber(LinkedList<String> filterOptions, String filterType) {
        try {
            String inputString = scanner.nextLine();
            int inputNumber = Integer.parseInt(inputString);

            if (Utils.isMainInput(inputNumber)) {
                view.showMainMenu();
                catchMainMenuInput();
            } else if (inputNumber > 0 && inputNumber <= filterOptions.size()) {
                ArrayList<SongData> filteredSongs = Utils.FilterSongs(model.getSongs(), filterOptions.get(inputNumber-1), filterType);
                view.showSongList(filteredSongs);
                catchSongNumber(filteredSongs);
            } else {
                view.showEnterNumberBetween(1, filterOptions.size());
                catchFilterNumber(filterOptions, filterType);
            }


        } catch (Exception e) {
            view.showWrongInput();
            catchFilterNumber(filterOptions, filterType);
        }
    }

    public void catchSearchSongInput() {

        String inputString = scanner.nextLine();

        if (inputString.equals("") || inputString.split(" ").length == 0) {
            view.showEnterSomethingValid();
            view.showEnterSongNumber();
            catchSearchSongInput();
        }

        ArrayList<SongData> filteredArraylist = new ArrayList<>();

        for (int i = 0; i < model.getSongs().size(); i++) {
            SongData songData = model.getSongs().get(i);
            if (songData.getSongName().toLowerCase().contains(inputString.toLowerCase())) {
                filteredArraylist.add(songData);
            }
        }

        if (filteredArraylist.size() == 0) {
            view.showNoMatchingSongFound();
            view.showSearchSongOption();
            catchSearchSongInput();
        } else {
            view.showSongList(filteredArraylist);
            catchSongNumber(filteredArraylist);
        }

    }

}
