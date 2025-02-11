package com.example.practica6;

import android.os.Bundle;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Switch switchDatos, switchWifi;
    private Button comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        switchDatos = findViewById(R.id.switchDatos);
        switchWifi = findViewById(R.id.switchWifi);

        comprobar = findViewById(R.id.button);

        comprobar.setOnClickListener(v -> {
            if (switchDatos.isChecked() && switchWifi.isChecked()) {
                Toast.makeText(this, "Los datos móviles y el wifi están activados", Toast.LENGTH_SHORT).show();
            } else if (!switchDatos.isChecked() && switchWifi.isChecked()) {
                Toast.makeText(this, "El wifi está activado", Toast.LENGTH_SHORT).show();
            } else if (switchDatos.isChecked() && !switchWifi.isChecked()) {
                Toast.makeText(this, "Los datos móviles están activados", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No hay conexión red", Toast.LENGTH_SHORT).show();
            }

        });
    }
}