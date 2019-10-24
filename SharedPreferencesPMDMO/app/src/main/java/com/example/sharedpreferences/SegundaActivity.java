package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    private static final String ARCHIVO = "SharedPMDMO";
    private static final String TELEFONO_PERSONA = "telefonoPersona";
    private Button btTercera;
    private EditText etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        btTercera = findViewById(R.id.btTercera);
        etTelefono = findViewById(R.id.etTelefono);

        btTercera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = etTelefono.getText().toString().trim();
                if(tel.isEmpty()){
                    Toast.makeText(SegundaActivity.this, "Por favor introduzca un número para continuar", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences sharedPref = getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(TELEFONO_PERSONA, tel);
                    editor.commit();
                    Intent intent = new Intent( SegundaActivity.this, TerceraActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
