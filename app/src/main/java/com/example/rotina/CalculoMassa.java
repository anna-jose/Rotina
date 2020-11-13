package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculoMassa extends AppCompatActivity {

    EditText edAltura, edPeso;
    Button btCalcular;
    TextView txResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_massa);
        carregaWidgets();
        calculoIMC();
    }

    private void carregaWidgets(){
        edAltura = (EditText)findViewById(R.id.edtAltura);
        edPeso = (EditText)findViewById(R.id.edtPeso);
        btCalcular = (Button)findViewById(R.id.btnCalcularIMC);
        txResultado = (TextView)findViewById(R.id.txtResultadoIMC);
    }
    private void calculoIMC(){
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double alt = Double.parseDouble(edAltura.getText().toString());
                Double peso = Double.parseDouble(edPeso.getText().toString());
                Double imc = peso / (alt*alt);
                //imc = imc / 0.1;
                txResultado.setText(imc.toString());
            }
        });


    }

}