package project.utilities;

public class SongData {
    public SongData(String songName, String album, String artist, String genre, String songFile, String image) {
        this.songName = songName;
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.songFile = songFile;
        this.image = image;
    }

    final private String songName, album, artist, genre, songFile, image;

    public String getSongName() {
        return songName;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getSongFile() {
        return songFile;
    }

    public String getImage() {
        return image;
    }
}
