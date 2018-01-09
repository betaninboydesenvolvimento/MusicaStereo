package com.comabetaninboydesenvolvimento.google.httpssites.musicalsodastereo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        ImageView homeImageView = findViewById(R.id.go_home_button);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goHomeIntent = new Intent(AlbumDetailsActivity.this, MainActivity.class);
                startActivity(goHomeIntent);
            }
        });

        ArrayList<AlbumDetails> albumUltimoConcerto = SongsList.getUltimoConcerto();
        ArrayList<AlbumDetails> albumDynamo = SongsList.getAlbumDynamo();
        ArrayList<AlbumDetails> albumGiraMeVerasVolver = SongsList.getAlbumGiraMeVerasVolver();
        ArrayList<AlbumDetails> albumDobleVida = SongsList.getAlbumDobleVida();
        ArrayList<AlbumDetails> albumSuenoStereo = SongsList.getAlbumSuenoStereo();
        ArrayList<AlbumDetails> albumSodaStereo = SongsList.getAlbumSodaStereo();
        ArrayList<AlbumDetails> albumSignos = SongsList.getAlbumSignos();
        ArrayList<AlbumDetails> albumCancionAnimal = SongsList.getAlbumCancionAnimal();

        Intent intent = getIntent();
        String albumName = intent.getStringExtra("album_name");
        String artistName = intent.getStringExtra("artist_name");
        int albumImage = intent.getIntExtra("album_image", R.drawable.gira);

        ListView listView = findViewById(R.id.album_detail_songs);

        switch (albumName) {
            case "Soda Stereo El último Concierto":
                AlbumDetailsAdapter ultimoConcertoAdapter = new AlbumDetailsAdapter(this, albumUltimoConcerto);
                listView.setAdapter(ultimoConcertoAdapter);
                showNowPlaySong(listView, albumUltimoConcerto);
                break;

            case "DYNAMO":
                AlbumDetailsAdapter albumDynamoAdapter = new AlbumDetailsAdapter(this, albumDynamo);
                listView.setAdapter(albumDynamoAdapter);
                showNowPlaySong(listView, albumDynamo);
                break;

            case "Gira Me Verás Volver":
                AlbumDetailsAdapter albumGiraMeVerasVolverAdapter = new AlbumDetailsAdapter(this, albumGiraMeVerasVolver);
                listView.setAdapter(albumGiraMeVerasVolverAdapter);
                showNowPlaySong(listView, albumGiraMeVerasVolver);
                break;

            case "Doble Vida":
                AlbumDetailsAdapter dobleVidaAdapter = new AlbumDetailsAdapter(this, albumDobleVida);
                listView.setAdapter(dobleVidaAdapter);
                showNowPlaySong(listView, albumDobleVida);
                break;

            case "Sueño Stereo":
                AlbumDetailsAdapter suenoStereoAdapter = new AlbumDetailsAdapter(this, albumSuenoStereo);
                listView.setAdapter(suenoStereoAdapter);
                showNowPlaySong(listView, albumSuenoStereo);
                break;

            case "Soda Stereo":
                AlbumDetailsAdapter sodaStereoAdapter = new AlbumDetailsAdapter(this, albumSodaStereo);
                listView.setAdapter(sodaStereoAdapter);
                showNowPlaySong(listView, albumSodaStereo);
                break;

            case "Signos":
                AlbumDetailsAdapter signosAdapter = new AlbumDetailsAdapter(this, albumSignos);
                listView.setAdapter(signosAdapter);
                showNowPlaySong(listView, albumSignos);
                break;

            case "Canción Animal":
                AlbumDetailsAdapter cancionAnimalAdapter = new AlbumDetailsAdapter(this, albumCancionAnimal);
                listView.setAdapter(cancionAnimalAdapter);
                showNowPlaySong(listView, albumCancionAnimal);
                break;

        }

        ImageView albumImageImageView = findViewById(R.id.album_detail_image);
        albumImageImageView.setImageResource(albumImage);

        TextView albumNameTextView = findViewById(R.id.album_detail_album);
        albumNameTextView.setText(albumName);

        TextView artistNameTextView = findViewById(R.id.album_detail_artist);
        artistNameTextView.setText(artistName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showNowPlaySong(ListView listView, final ArrayList<AlbumDetails> currentAlbum) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(AlbumDetailsActivity.this, NowPlayActivity.class);

                AlbumDetails currentSong = currentAlbum.get(position);

                Bundle bundle = new Bundle();
                bundle.putString("album_name", currentSong.getAlbumName());
                bundle.putString("song_name", currentSong.getSongName());
                bundle.putString("artist_name", currentSong.getArtistName());
                bundle.putInt("album_image", currentSong.getImageAlbumResource());
                bundle.putInt("song_id", currentSong.getSongId());

                intent.putExtras(bundle);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}