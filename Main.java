import java.util.*;

// Song Class
class Song {
    private String title;
    private String artist;
    private int bpm;

    public Song(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", bpm=" + bpm +
                '}';
    }
}

// Mock Song Class
class MockSong {
    public static List<Song> getSongList() {
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song("somersault", "zero 7", 147));
        songs.add(new Song("cassidy", "grateful dead", 158));
        songs.add(new Song("$10", "hitchhiker", 140));
        songs.add(new Song("havana", "cabello", 105));
        songs.add(new Song("Cassidy", "grateful dead", 158));
        songs.add(new Song("50 ways", "simon", 102));
        return songs;
    }
}

// Comparator Classes
class SongTitleComparator implements Comparator <Song> {
    public int compare(Song obj1, Song obj2) {
        return obj1.getTitle().compareTo(obj2.getTitle());
    }
}

class SongArtistComparator implements Comparator <Song> {
    public int compare(Song obj1, Song obj2) {
        return obj1.getArtist().compareTo(obj2.getArtist());
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Java Data Structure - Sorting");
        System.out.println("Sorting - Using Comparator");

        System.out.println("Getting List of Songs");
        List<Song> songList = MockSong.getSongList();
        System.out.println(songList);

        // Sorted By Title
        SongTitleComparator songTitleComparator = new SongTitleComparator();
        songList.sort(songTitleComparator);
        System.out.println("Sorted Song List by Title");
        System.out.println(songList);

        // Sorted By Artist
        SongArtistComparator songArtistComparator = new SongArtistComparator();
        songList.sort(songArtistComparator);
        System.out.println("Sorted Song List by Artist");
        System.out.println(songList);
    }
}