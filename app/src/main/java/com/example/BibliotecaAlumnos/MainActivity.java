package com.example.BibliotecaAlumnos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.BibliotecaAlumnos.R;

public class MainActivity extends AppCompatActivity {

    private static final String USUARIO_CORRECTO = "admin";
    private static final String CONTRASEÑA_CORRECTA = "admin";

    private EditText editTextUsuario;
    private EditText editTextContraseña;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Oculta la barra de acción en MainActivity
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContraseña = findViewById(R.id.editTextContraseña);
        Button buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion);

        buttonIniciarSesion.setOnClickListener(view -> {
            iniciarSesion();
        });
    }

    private void iniciarSesion() {
        String usuario = editTextUsuario.getText().toString();
        String contraseña = editTextContraseña.getText().toString();

        // Verificar las credenciales
        if (usuario.equals(USUARIO_CORRECTO) && contraseña.equals(CONTRASEÑA_CORRECTA)) {
            // Credenciales correctas, iniciar la siguiente actividad
            toCategoriaActivity();
        } else {
            // Credenciales incorrectas, mostrar un mensaje de error
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void toCategoriaActivity() {
        Intent intent = new Intent(MainActivity.this, ViewInicio.class);
        startActivity(intent);
        finish();
    }
}
