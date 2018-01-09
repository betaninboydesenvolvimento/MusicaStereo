package com.comabetaninboydesenvolvimento.google.httpssites.musicalsodastereo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AlbumDetails> albumDetails = AlbumList.getSongDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.grid_view_albums);
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albumDetails);
        gridView.setAdapter(albumAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent albumDetailsIntent = new Intent(MainActivity.this, AlbumDetailsActivity.class);
                AlbumDetails currentSong = albumDetails.get(position);

                Bundle bundle = new Bundle();
                bundle.putString("album_name", currentSong.getAlbumName());
                bundle.putString("artist_name", currentSong.getArtistName());
                bundle.putInt("album_image", currentSong.getImageAlbumResource());

                albumDetailsIntent.putExtras(bundle);
                albumDetailsIntent.putExtras(bundle);
                startActivity(albumDetailsIntent);
            }
        });
    }
}