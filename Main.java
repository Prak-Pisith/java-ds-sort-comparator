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

    // hashCode and equals for comparison in Set
    @Override
    public int hashCode() {
        return Objects.hash(title, artist, bpm);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return Integer.compare(song.bpm, bpm) == 0 &&
                Objects.equals(title, song.title) &&
                Objects.equals(artist, song.artist);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", bpm=" + bpm +
                '}';
    }

//    @java.lang.Override
//    public boolean equals(Object object) {
//        if (this == object) return true;
//        if (object == null || getClass() != object.getClass()) return false;
//        if (!super.equals(object)) return false;
//        Song song = (Song) object;
//        return bpm == song.bpm && java.util.Objects.equals(title, song.title) && java.util.Objects.equals(artist, song.artist);
//    }
//
//    @java.lang.Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), title, artist, bpm);
//    }
}

// Mock Song Class
class MockSong {
    public static List<Song> getSongList() {
        List<Song> songs = new ArrayList<Song>();
        songs.add(new Song("somersault", "zero 7", 147));
        songs.add(new Song("cassidy", "grateful dead", 158));
        songs.add(new Song("$10", "hitchhiker", 140));
        songs.add(new Song("havana", "cabello", 105));
        songs.add(new Song("cassidy", "grateful dead", 158));
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
        System.out.println("Total => " + songList.size());

        // Sorted By Title
        SongTitleComparator songTitleComparator = new SongTitleComparator();
        songList.sort(songTitleComparator);
        System.out.println("Sorted Song List by Title");
        System.out.println(songList);
        System.out.println("Total => " + songList.size());

        // Sorted By Artist
        SongArtistComparator songArtistComparator = new SongArtistComparator();
        songList.sort(songArtistComparator);
        System.out.println("Sorted Song List by Artist");
        System.out.println(songList);
        System.out.println("Total => " + songList.size());

        // Using Lambda Functions
        System.out.println("Comparator using LAMBDA Functions");
        System.out.println("============== LAMBDA ===============");

        songList.sort((obj1, obj2) -> obj1.getTitle().compareTo(obj2.getTitle()));
        System.out.println("Sorted Song List by Title");
        System.out.println(songList);
        System.out.println("Total => " + songList.size());

        songList.sort((obj1, obj2) -> obj1.getArtist().compareTo(obj2.getArtist()));
        System.out.println("Sorted Song List by Artist");
        System.out.println(songList);
        System.out.println("Total => " + songList.size());

        // Set
        System.out.println("============== SET (NO DUPLICATION) ===============");

        Set<Song> songSet = new HashSet<Song> (songList);
        System.out.println("Sorted Song Set (No Duplication)");
        System.out.println(songSet);
        System.out.println("Total => " + songSet.size());

        System.out.println("");
        System.out.println("============== HashCode Song ==============");
        System.out.println("Song List Hash =====>");
        for (Song song : songList) {
            System.out.println("Song " + song.getTitle() + " has song code: " + song.hashCode());
        }
        System.out.println("Song Set Hash  =====>");
        for (Song song : songSet) {
            System.out.println("Song " + song.getTitle() + " has song code: " + song.hashCode());
        }
    }
}