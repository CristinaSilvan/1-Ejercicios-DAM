package com.example.practica3;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView introduce1, introduce2, resulSuma, resulResta, resulMulti, resulDiv;
    private EditText cuadro1, cuadro2;
    private Button calcular;
    private CheckBox suma, resta, multi, div;

    private void limpiar() {
        resulSuma.setText("Suma: ");
        resulResta.setText("Resta: ");
        resulMulti.setText("Multiplicación: ");
        resulDiv.setText("División: ");
    }

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

        introduce1 = findViewById(R.id.introduce1);
        introduce2 = findViewById(R.id.introduce2);
        resulSuma = findViewById(R.id.resultadoSuma);
        resulResta = findViewById(R.id.resultadoResta);
        resulMulti = findViewById(R.id.resultadoMulti);
        resulDiv = findViewById(R.id.resultadoDiv);

        cuadro1 = findViewById(R.id.cuadro1);
        cuadro2 = findViewById(R.id.cuadro2);

        calcular = findViewById(R.id.calcular);

        suma = findViewById(R.id.sumar);
        resta = findViewById(R.id.restar);
        multi = findViewById(R.id.multiplicar);
        div = findViewById(R.id.dividir);
        limpiar();


        calcular.setOnClickListener(v -> {
            limpiar();

            if (cuadro1.getText().toString().isEmpty() || cuadro2.getText().toString().isEmpty()) {
                Toast.makeText(this, "Introduce ambos números", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(!suma.isChecked() && !resta.isChecked() && !multi.isChecked() && !div.isChecked()){
                Toast.makeText(this, "Selecciona una operación", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                int numero1 = Integer.parseInt(cuadro1.getText().toString());
                int numero2 = Integer.parseInt(cuadro2.getText().toString());

                if (suma.isChecked()) {
                    resulSuma.setText("Suma: " + (Integer.parseInt(cuadro1.getText().toString()) + Integer.parseInt(String.valueOf(cuadro2.getText().toString()))));
                    resulSuma.setVisibility(View.VISIBLE);
                }

                if (resta.isChecked()) {
                    resulResta.setText("Resta: " + (Integer.parseInt(cuadro1.getText().toString()) - Integer.parseInt(String.valueOf(cuadro2.getText().toString()))));
                    resulResta.setVisibility(View.VISIBLE);
                }

                if (multi.isChecked()) {
                    resulMulti.setText("Multiplicación: " + (Integer.parseInt(cuadro1.getText().toString()) * Integer.parseInt(String.valueOf(cuadro2.getText().toString()))));
                    resulMulti.setVisibility(View.VISIBLE);
                }

                if (div.isChecked()) {
                    if (numero2 != 0) {
                        resulDiv.setText("División: " + (Integer.parseInt(cuadro1.getText().toString()) / Integer.parseInt(String.valueOf(cuadro2.getText().toString()))));
                        resulDiv.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Introduce números válidos", Toast.LENGTH_SHORT).show();
            }
        });

    }

}