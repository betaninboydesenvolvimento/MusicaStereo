package com.comabetaninboydesenvolvimento.google.httpssites.musicalsodastereo;

/**
 * Created by lucas on 08/01/2018.
 */

public class AlbumDetails {
    private String songName;
    private String ArtistName;
    private String AlbumName;
    private int imageAlbumResource;
    private int songId;

    public AlbumDetails(String artistName, String albumName, int imageAlbumResource) {
        this.ArtistName = artistName;
        this.AlbumName = albumName;
        this.imageAlbumResource = imageAlbumResource;
    }

    public AlbumDetails(int songId, String songName, String artistName, String albumName, int imageAlbumResource) {
        this.songId = songId;
        this.songName = songName;
        this.ArtistName = artistName;
        this.AlbumName = albumName;
        this.imageAlbumResource = imageAlbumResource;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public int getImageAlbumResource() {
        return imageAlbumResource;
    }

    public int getSongId() {
        return songId;
    }
}

