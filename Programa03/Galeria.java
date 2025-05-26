//Hernández Hernández Luis Fernando
package com.example.galeria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Galeria extends Activity {
    ImageView imagenActual;
    TextView textoDescripcion;
    int indiceActual;
    String[] descripciones = {"Batman", "Spiderman", "Omniman"};

    int[] arregloImagenes = {
            R.drawable.batman,
            R.drawable.spiderman,
            R.drawable.omniman
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista);

        imagenActual = findViewById(R.id.img1);
        textoDescripcion = findViewById(R.id.tv1);

        indiceActual = 0;

        imagenActual.setImageResource(arregloImagenes[indiceActual]);
        textoDescripcion.setText(descripciones[indiceActual]);
    }

    public void atras(View v) {
        if (indiceActual == 0) {

            indiceActual = arregloImagenes.length - 1;
        } else {
            indiceActual--;
        }
        actualizarContenido();
    }

    public void adelante(View v) {
        if (indiceActual == arregloImagenes.length - 1) {
            indiceActual = 0;
        } else {
            indiceActual++;
        }
        actualizarContenido();
    }

    private void actualizarContenido() {
        imagenActual.setImageResource(arregloImagenes[indiceActual]);
        textoDescripcion.setText(descripciones[indiceActual]);
        Toast.makeText(this, "Mostrando: " + descripciones[indiceActual], Toast.LENGTH_SHORT).show();
    }
}