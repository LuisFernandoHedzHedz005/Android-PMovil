//Hernández Hernández Luis Fernando
package com.example.programa02;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Calculadora extends Activity {
    private EditText pantalla;
    Button[] botones = new Button[10];
    private String entradaActual = "";
    private int operador;
    private double primerNumero = 0;
    double resultado;

    // Arreglo de los botones de los números
    int botonesNumericos[] = {
            R.id.button0,
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9};


    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.pantalla);
//pantalla.setTextColor(Color.GREEN);
        pantalla.setTextColor(Color.parseColor("#FF0000"));
        pantalla.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);


        View.OnClickListener listenerBotonNumerico = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button boton = (Button) v;
                entradaActual += boton.getText().toString();
                pantalla.setText(entradaActual);
            }
        };

        for (int i = 0; i <= 9; i++) {
            botones[i] = findViewById(botonesNumericos[i]);
            botones[i].setOnClickListener(listenerBotonNumerico);
        }
    }


    public void metodosumar(View view) {
        primerNumero = Double.parseDouble(pantalla.getText() + "");
        pantalla.setText("");
        entradaActual = "";
        operador = 1;
    }

    public void metodorestar(View view) {
        primerNumero = Double.parseDouble(pantalla.getText() + "");
        pantalla.setText("");
        entradaActual = "";
        operador = 2;
    }

    public void metodomultiplicar(View view) {
        primerNumero = Double.parseDouble(pantalla.getText() + "");
        pantalla.setText("");
        entradaActual = "";
        operador = 3;
    }

    public void metododividir(View view) {
        primerNumero = Double.parseDouble(pantalla.getText() + "");
        pantalla.setText("");
        entradaActual = "";
        operador = 4;
    }

    public void metodoigual(View v) {
        double segundoNumero = Double.parseDouble(pantalla.getText() + "");

        switch (operador) {
            case 1:
                resultado = primerNumero + segundoNumero;
                break;
            case 2:
                resultado = primerNumero - segundoNumero;
                break;
            case 3:
                resultado = primerNumero * segundoNumero;
                break;
            case 4:
                if (segundoNumero == 0) {
                    pantalla.setText("Error");
                    entradaActual = "";
                    primerNumero = 0;
                    return;
                }
                resultado = primerNumero / segundoNumero;
                break;
        }
        pantalla.setText(String.valueOf(resultado));
        entradaActual = String.valueOf(resultado);
        primerNumero = resultado;
    }
}
