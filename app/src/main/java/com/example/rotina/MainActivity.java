package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btIMC, btRotina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregaWidgets();
        imc();
    }

    private void carregaWidgets(){
        btIMC = (Button)findViewById(R.id.btnIMC);
        btRotina = (Button)findViewById(R.id.btnRotina);
    }
    private void imc(){
        btIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculoMassa.class);
                startActivity(intent);
            }
        });

        btRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Não implementado ainda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}