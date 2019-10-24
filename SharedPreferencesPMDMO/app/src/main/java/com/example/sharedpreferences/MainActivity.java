package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SharedPMDMO";
    private static final String ARCHIVO = "SharedPMDMO";
    private static final String NOMBRE_PERSONA = "nombrePersona";
    private static final String CORREO_PERSONA = "correoPersona";
    private static final String DIRECCION_PERSONA = "direccionPersona";
    private String nombre = "Fulanito";
    private String correo = "fulano@mengano.com";
    private String direccion = "el quinto pino";
    private Button btCargar, btGuardar, btSegunda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btCargar = findViewById(R.id.btCargar);
        btGuardar = findViewById(R.id.btGuardar);
        btSegunda = findViewById(R.id.btSegunda);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(NOMBRE_PERSONA, nombre);
                editor.putString(CORREO_PERSONA, correo);
                editor.putString(DIRECCION_PERSONA, direccion);
                editor.commit();
            }
        });

        btCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
                String nombre_preferencia = sharedPreferences.getString(NOMBRE_PERSONA, "no encontramos el nombre");
                String direccion_preferencia = sharedPreferences.getString(DIRECCION_PERSONA, "no encontramos la direccion");
                String correo_preferencia = sharedPreferences.getString(CORREO_PERSONA, "no encontramos el correo");
                Log.v(TAG, nombre_preferencia);
                Log.v(TAG, direccion_preferencia);
                Log.v(TAG, correo_preferencia);
            }
        });

        btSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, SegundaActivity.class);
                startActivity(intent);
            }
        });

        /*
        SharedPreferences prefs = getSharedPreferences("nombre_del_archivo", Context.MODE_PRIVATE);
        */

    }
}