package com.comabetaninboydesenvolvimento.google.httpssites.musicalsodastereo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NowPlayActivity extends AppCompatActivity {
    boolean isPlaying = false;
    int currentIndex = 0;
    int clickIndex = 0;
    ArrayList<AlbumDetails> currentAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<AlbumDetails> albumUltimoConcerto = SongsList.getUltimoConcerto();
        ArrayList<AlbumDetails> albumDynamo = SongsList.getAlbumDynamo();
        ArrayList<AlbumDetails> albumGiraMeVerasVolver = SongsList.getAlbumGiraMeVerasVolver();
        ArrayList<AlbumDetails> albumDobleVida = SongsList.getAlbumDobleVida();
        ArrayList<AlbumDetails> albumSuenoStereo = SongsList.getAlbumSuenoStereo();
        ArrayList<AlbumDetails> albumSodaStereo = SongsList.getAlbumSodaStereo();
        ArrayList<AlbumDetails> albumSignos = SongsList.getAlbumSignos();
        ArrayList<AlbumDetails> albumCancionAnimal = SongsList.getAlbumCancionAnimal();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_play);

        final Intent intent = getIntent();
        final String songName = intent.getStringExtra("song_name");
        final String albumName = intent.getStringExtra("album_name");
        final String artistName = intent.getStringExtra("artist_name");
        final int albumImage = intent.getIntExtra("album_image", R.drawable.gira);
        final int songId = intent.getIntExtra("song_id", 0);

        ImageView homeImageView = findViewById(R.id.go_home_now_play);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goHomeIntent = new Intent(NowPlayActivity.this, MainActivity.class);
                startActivity(goHomeIntent);
            }
        });

        ImageView albumImageView = findViewById(R.id.go_album_now_play);
        albumImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent goAlbumIntent = new Intent(NowPlayActivity.this, AlbumDetailsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("album_name", albumName);
                bundle.putString("artist_name", artistName);
                bundle.putInt("album_image", albumImage);
                goAlbumIntent.putExtras(bundle);
                startActivity(goAlbumIntent);
            }
        });

        switch (albumName) {
            case "El Último Concierto A":
                currentAlbum = albumUltimoConcerto;
                break;
            case "Dynamo":
                currentAlbum = albumDynamo;
                break;
            case "Gira Me Verás Volver":
                currentAlbum = albumGiraMeVerasVolver;
                break;
            case "Doble Vida":
                currentAlbum = albumDobleVida;
                break;
            case "Sueño Stereo":
                currentAlbum = albumSuenoStereo;
                break;
            case "Soda Stereo":
                currentAlbum = albumSodaStereo;
                break;
            case "Signos":
                currentAlbum = albumSignos;
                break;
            case "Canción Animal":
                currentAlbum = albumCancionAnimal;
                break;
        }

        ImageView albumImageImageView = findViewById(R.id.now_play_image_album);
        albumImageImageView.setImageResource(albumImage);

        TextView songNameTextView = findViewById(R.id.now_play_song_name);
        songNameTextView.setText(songName);

        TextView artistNameTextView = findViewById(R.id.now_play_artist_name);
        artistNameTextView.setText(artistName);

        ImageView playButton = findViewById(R.id.play_pause_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPlaying = !isPlaying;
                if (isPlaying) {
                    ImageView pauseButton = findViewById(R.id.play_pause_button);
                    pauseButton.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);

                    String currentSongName = currentAlbum.get(currentIndex).getSongName();

                    if (clickIndex == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Agora você está escutando: " + songName, Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Agora você está escutando: " + currentSongName, Toast.LENGTH_SHORT);
                        toast.show();
                    }

                } else {
                    ImageView playButton = findViewById(R.id.play_pause_button);
                    playButton.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                }
            }
        });

        ImageView nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex == 0 && clickIndex == 0) {
                    currentIndex = songId;
                } else {
                    currentIndex++;
                    clickIndex++;
                }
                if (!(currentIndex < currentAlbum.size())) {
                    currentIndex = 0;
                }
                String songName = currentAlbum.get(currentIndex).getSongName();
                TextView songNameTextView = findViewById(R.id.now_play_song_name);
                songNameTextView.setText(songName);
            }
        });

        ImageView reverseButton = findViewById(R.id.reverse_button);
        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickIndex == 0) {
                    currentIndex = songId - 1;
                    currentIndex = currentIndex - 1;
                    clickIndex++;
                } else {
                    currentIndex = currentIndex - 1;
                    clickIndex++;
                }
                if (currentIndex < 0) {
                    currentIndex = 0;
                }
                String songName = currentAlbum.get(currentIndex).getSongName();
                TextView songNameTextView = findViewById(R.id.now_play_song_name);
                songNameTextView.setText(songName);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
