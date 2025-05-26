//Hernández Hernández Luis Fernando
package com.example.programa04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Creditos extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
    }

    public void regresar_principal(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}