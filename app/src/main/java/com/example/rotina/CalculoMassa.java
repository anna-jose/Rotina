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

                if (imc < 19){
                    txResultado.setText(String.format("IMC = %.1f\nVocê está abaixo do peso!" , imc));
                }else if (imc >=19 && imc <24.9){
                    txResultado.setText(String.format("IMC = %.1f\nVocê está com o peso normal, bom trabalho!" , imc));
                }else if (imc >=25 && imc < 29.9){
                    txResultado.setText(String.format("IMC = %.1f\nVocê está com sobrepeso, tome cuidado!" , imc));
                }else if (imc >= 30 && imc < 39.9){
                    txResultado.setText(String.format("IMC = %.2f\nSeu IMC indica Obesidade Tipo 1, tome cuidado!" , imc));
                }else{
                    txResultado.setText(String.format("IMC = %.2f\nSeu IMC indica Obesidade Tipo 2, procure ajuda profissional!" , imc));
                }

                //ao implementar o armazenamento da variável, colocar isso em um método próprio void. tornar imc público



//                txResultado.setText(String.format("IMC = %.1f" , imc)); //finalmente deu certo essa benção aaaaaaaaaaaaaaaaa
            }
        });

//        Se o IMC estiver abaixo de 19, está Abaixo do Peso.
//        Entre 19 e 24,9, peso Normal.
//        Entre 25 e 29,9 é considerado Sobrepeso.
//        Entre 30 e 39,9, Obesidade Tipo I.
//        Acima de 40 é Obesidade Mórbida.

    }

}