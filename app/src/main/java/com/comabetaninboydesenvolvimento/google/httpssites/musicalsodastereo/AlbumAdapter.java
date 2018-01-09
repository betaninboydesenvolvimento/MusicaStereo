package com.comabetaninboydesenvolvimento.google.httpssites.musicalsodastereo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lucas on 08/01/2018.
 */

public class AlbumAdapter extends ArrayAdapter<AlbumDetails> {

    public AlbumAdapter(Context context, ArrayList<AlbumDetails> albumList) {
        super(context, 0, albumList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;

        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_grid_item, parent, false);
        }
        AlbumDetails currentSong = getItem(position);

        ImageView albumImage = gridItemView.findViewById(R.id.album_grid_image);
        albumImage.setImageResource(currentSong.getImageAlbumResource());

        TextView albumName = gridItemView.findViewById(R.id.album_grid_name);
        albumName.setText(currentSong.getAlbumName().toString());

        TextView artistName = gridItemView.findViewById(R.id.album_grid_artist);
        artistName.setText(currentSong.getArtistName().toString());

        return gridItemView;

    }
}
