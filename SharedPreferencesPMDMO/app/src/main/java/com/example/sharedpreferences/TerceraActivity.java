package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TerceraActivity extends AppCompatActivity {

    private TextView tvNombreMostrar, tvCorreoMostrar, tvDireccionMostrar, tvTelefonoMostrar;
    private static final String ARCHIVO = "SharedPMDMO";
    private static final String NOMBRE_PERSONA = "nombrePersona";
    private static final String CORREO_PERSONA = "correoPersona";
    private static final String DIRECCION_PERSONA = "direccionPersona";
    private static final String TELEFONO_PERSONA = "telefonoPersona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        tvCorreoMostrar = findViewById(R.id.tvCorreoMostrar);
        tvNombreMostrar = findViewById(R.id.tvNombreMostrar);
        tvDireccionMostrar = findViewById(R.id.tvDireccionMostrar);
        tvTelefonoMostrar = findViewById(R.id.tvTelefonoMostrar);

        SharedPreferences sharedPreferences = getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
        tvNombreMostrar.setText(sharedPreferences.getString(NOMBRE_PERSONA, "no encontramos el nombre"));
        tvCorreoMostrar.setText(sharedPreferences.getString(CORREO_PERSONA, "no encontramos el correo"));
        tvDireccionMostrar.setText(sharedPreferences.getString(DIRECCION_PERSONA, "no encontramos la direccion"));
        tvTelefonoMostrar.setText(sharedPreferences.getString(TELEFONO_PERSONA, "no encontramos el teléfono"));
    }
}
