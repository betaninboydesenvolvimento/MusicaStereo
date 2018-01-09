package com.comabetaninboydesenvolvimento.google.httpssites.musicalsodastereo;

import java.util.ArrayList;

/**
 * Created by lucas on 08/01/2018.
 */

public class AlbumList {
    public static ArrayList<AlbumDetails> getSongDetails() {
        ArrayList<AlbumDetails> albumDetails;
        albumDetails = new ArrayList<>();
        albumDetails.add(new AlbumDetails("Soda Stereo", "El Último Concierto", R.drawable.ultimoconcierto));
        albumDetails.add(new AlbumDetails("Soda Stereo", "Dynamo", R.drawable.dynamo));
        albumDetails.add(new AlbumDetails("Soda Stereo", "Gira Me Verás Volver", R.drawable.gira));
        albumDetails.add(new AlbumDetails("Soda Stereo", "Doble Vida", R.drawable.doble));
        albumDetails.add(new AlbumDetails("Soda Stereo", "Sueño Stereo", R.drawable.sueno));
        albumDetails.add(new AlbumDetails("Soda Stereo", "Soda Stereo", R.drawable.soda));
        albumDetails.add(new AlbumDetails("Soda Stereo", "Signos", R.drawable.signos));
        albumDetails.add(new AlbumDetails("Soda Stereo", "Canción Animal", R.drawable.cancion));
        return albumDetails;
    }
}
