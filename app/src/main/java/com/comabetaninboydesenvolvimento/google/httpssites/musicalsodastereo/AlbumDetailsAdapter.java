package com.comabetaninboydesenvolvimento.google.httpssites.musicalsodastereo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lucas on 08/01/2018.
 */

public class AlbumDetailsAdapter extends ArrayAdapter<AlbumDetails> {

    public AlbumDetailsAdapter(@NonNull Context context, ArrayList<AlbumDetails> albumDetailsArrayList) {
        super(context, 0, albumDetailsArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_song_list_item, parent, false);
        }
        AlbumDetails currentAlbum = getItem(position);

        TextView songAlbum = listItemView.findViewById(R.id.song_item_list);
        songAlbum.setText(currentAlbum.getSongName().toString());

        return listItemView;
    }
}
