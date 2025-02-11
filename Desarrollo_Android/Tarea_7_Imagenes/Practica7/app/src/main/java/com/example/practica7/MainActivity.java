package com.example.practica7;

import android.os.Bundle;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton cubelete;
    private ImageView dado1, dado2;

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

        cubelete = findViewById(R.id.cubelete);
        dado1  = findViewById(R.id.dado1);
        dado2 = findViewById(R.id.dado2);

        int[] caras = {
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
        };

        Random aleatorio = new Random();

        dado1.setVisibility(GridView.INVISIBLE);
        dado2.setVisibility(GridView.INVISIBLE);

        cubelete.setOnClickListener(v -> {

            dado1.setVisibility(GridView.VISIBLE);
            dado2.setVisibility(GridView.VISIBLE);

            int cara1 = aleatorio.nextInt(6);
            int cara2 = aleatorio.nextInt(6);

            dado1.setImageResource(caras[cara1]);
            dado2.setImageResource(caras[cara2]);

            if(cara1 == cara2){
                Toast.makeText(this, "¡Las dos caras coinciden!" ,Toast.LENGTH_SHORT).show();
            }
        });

    }
}