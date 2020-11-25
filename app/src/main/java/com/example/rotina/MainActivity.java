package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btIMC, btRotina, btInfo;

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
        btInfo = (Button)findViewById(R.id.btnInfo);
    }
    private void imc(){
        btIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaImc = new Intent(MainActivity.this, CalculoMassa.class);
                startActivity(telaImc);
            }
        });

        btRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaRotina = new Intent(MainActivity.this, EtapaActivity.class);
                startActivity(telaRotina);
            }
        });
        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaInfo = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(telaInfo);
            }
        });
    }
}