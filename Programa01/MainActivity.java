//Hernández Hernández Luis Fernando
package com.example.programa01;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;

    TextView tv1;
    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.numuno);
        et2 = (EditText) findViewById(R.id.numdos);
        tv1 = (TextView) findViewById(R.id.resultado);
        }

    public void metodosumar (View v){
        String numero1Str = et1.getText().toString();
        String numero2Str = et2.getText().toString();

        if (numero1Str.isEmpty() || numero2Str.isEmpty()) {
            // Campos vacios
            Toast.makeText(this, "Por favor, ingresa ambos números.", Toast.LENGTH_SHORT).show();
            tv1.setText("Resultado: ");
            return; // Salir si estan vacios
        }

        try {
            int numero1 = Integer.parseInt(numero1Str);
            int numero2 = Integer.parseInt(numero2Str);

            int res = numero1 + numero2;
            tv1.setText("Resultado: " + String.valueOf(res)); // Resultado
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingresa números válidos.", Toast.LENGTH_SHORT).show();
            tv1.setText("Resultado: "); // Limpiar
        }
    }
}