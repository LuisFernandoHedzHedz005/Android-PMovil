//Hernández Hernández Luis Fernando

package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejecutar(View v) {
        try {
            Uri datos = Uri.parse(getExternalFilesDir(null).toString() + "/gato.mp3");
            MediaPlayer mp = MediaPlayer.create(this, datos);


            if (mp != null) {
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            } else {
                System.out.println("Error: No se pudo cargar el archivo de audio.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al reproducir el audio: " + e.getMessage());
        }
    }
}