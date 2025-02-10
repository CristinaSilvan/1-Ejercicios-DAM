package com.example.practica8;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button calcular;
    private EditText num1, num2;
    private TextView resultado;
    private Spinner lista;
    String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.num1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calcular = findViewById(R.id.boton);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultado = findViewById(R.id.resultado);
        resultado.setVisibility(View.INVISIBLE);
        lista = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opciones);
        lista.setAdapter(adapter);

        calcular.setOnClickListener(v -> {
            String numTexto_1 = num1.getText().toString();
            String numTexto_2 = num2.getText().toString();

            if (numTexto_1.isEmpty() || numTexto_2.isEmpty()) {
                Toast.makeText(this, "Ingresa los dos números", Toast.LENGTH_SHORT).show();
            }
            else{
                resultado.setVisibility(View.VISIBLE);
                float num_1 = Float.parseFloat(num1.getText().toString());
                float num_2 = Float.parseFloat(num2.getText().toString());
                float resultadoNum = 0.0f;

                if(lista.getSelectedItem().toString().equals("Sumar")){
                    resultadoNum = num_1 + num_2;
                }
                else if(lista.getSelectedItem().toString().equals("Restar")){
                    resultadoNum = num_1 - num_2;
                }
                else if(lista.getSelectedItem().toString().equals("Multiplicar")){
                    resultadoNum = num_1 * num_2;
                }
                else{
                    resultadoNum = num_1 / num_2;
                }

                resultado.setText("El resultado es: " + resultadoNum);
            }
        });

    }
}