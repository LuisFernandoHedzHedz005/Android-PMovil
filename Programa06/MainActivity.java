//Hernández Hernández Luis Fernando
package com.example.bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
    }

    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();

        if (cod.isEmpty() || descri.isEmpty() || pre.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Integer.parseInt(cod);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El código debe ser un número entero válido", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Double.parseDouble(pre);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El precio debe ser un número decimal válido", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);

        long resultado = bd.insert("articulos", null, registro);
        bd.close();

        if (resultado != -1) {
            et1.setText("");
            et2.setText("");
            et3.setText("");
            Toast.makeText(this, "Se cargaron los datos del artículo",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al cargar los datos. El código podría ya existir.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void consultaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String cod = et1.getText().toString();

        if (cod.isEmpty()) {
            Toast.makeText(this, "Ingrese un código para consultar", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor fila = bd.rawQuery(
                "select descripcion,precio from articulos where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else {
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
            et2.setText("");
            et3.setText("");
        }
        fila.close();
        bd.close();
    }

    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String descri = et2.getText().toString();

        if (descri.isEmpty()) {
            Toast.makeText(this, "Ingrese una descripción para consultar", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor fila = bd.rawQuery(
                "select codigo,precio from articulos where descripcion='" + descri +"'", null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else {
            Toast.makeText(this, "No existe un artículo con dicha descripción",
                    Toast.LENGTH_SHORT).show();
            et1.setText("");
            et3.setText("");
        }
        fila.close();
        bd.close();
    }

    public void bajaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et1.getText().toString();

        if (cod.isEmpty()) {
            Toast.makeText(this, "Ingrese un código para dar de baja", Toast.LENGTH_SHORT).show();
            return;
        }

        int cant = bd.delete("articulos", "codigo=" + cod, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        if (cant == 1) {
            Toast.makeText(this, "Se borró el artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();

        if (cod.isEmpty() || descri.isEmpty() || pre.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios para la modificación", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Integer.parseInt(cod);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El código debe ser un número entero válido", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Double.parseDouble(pre);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El precio debe ser un número decimal válido", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues registro = new ContentValues();
        registro.put("descripcion", descri);
        registro.put("precio", pre);

        int cant = bd.update("articulos", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1) {
            Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
            et1.setText("");
            et2.setText("");
            et3.setText("");
        } else {
            Toast.makeText(this, "No existe un artículo con el código ingresado para modificar",
                    Toast.LENGTH_SHORT).show();
        }
    }
}