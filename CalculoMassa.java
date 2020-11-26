package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculoMassa extends AppCompatActivity {

    //............TO DO
    //IMPLEMENTAR ARMAZENAMENTO LOCAL DA VARIAVEL IMC
    //IMPLEMENTAR SOLUÇÃO PARA NÃO CALCULAR COM CAMPOS VAZIOS (CRASHA O APP) :( == okkk

    EditText edAltura, edPeso;
    Button btCalcular, btResetar;
    TextView txResultado;

    String valorImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_massa);

        final SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("imc", Context.MODE_PRIVATE);
        final SharedPreferences.Editor sharedPref = sharedPreferences.edit();

        carregaWidgets();

        valorImc = sharedPreferences.getString("imc","default");

        if (valorImc == "default"){
            txResultado.setText("IMC = "+valorImc);
            //txResultado.setText("Calcule seu IMC!");
        }else{
            //valorImc = sharedPreferences.getString("imc","default");
            txResultado.setText("Último IMC = "+valorImc);
            //txResultado.setText(String.format("Último IMC = %.1f" , valorImc));   //por algum motivo não funciona com esse formato e vai pra condição anterior
        }

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txResultado.setText("");

                Double alt = edAltura.getText().toString().equals("") ? 0 : Double.parseDouble(edAltura.getText().toString());
                Double peso = edPeso.getText().toString().equals("") ? 0 : Double.parseDouble(edPeso.getText().toString());

                if (alt <= 0 || peso <= 0 || alt == null || peso == null){
                    Toast.makeText(CalculoMassa.this, "Valor inválido!", Toast.LENGTH_SHORT).show();
                }
                else{
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

                    //double valor = imc;
                    sharedPref.putString("imc", ""+imc);
                    sharedPref.commit();
                }
//                txResultado.setText(String.format("IMC = %.1f" , imc)); //finalmente deu certo essa benção aaaaaaaaaaaaaaaaa
            }
        });

        btResetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref.putString("imc", null);
                sharedPref.commit();
                Toast.makeText(CalculoMassa.this, "IMC Resetado!", Toast.LENGTH_SHORT).show();

                valorImc = sharedPreferences.getString("imc","default");
                txResultado.setText("IMC = "+valorImc);
            }
        });


//        Se o IMC estiver abaixo de 19, está Abaixo do Peso.
//        Entre 19 e 24,9, peso Normal.
//        Entre 25 e 29,9 é considerado Sobrepeso.
//        Entre 30 e 39,9, Obesidade Tipo I.
//        Acima de 40 é Obesidade Mórbida.
    }

    private void carregaWidgets(){
        edAltura = (EditText)findViewById(R.id.edtAltura);
        edPeso = (EditText)findViewById(R.id.edtPeso);
        btCalcular = (Button)findViewById(R.id.btnCalcularIMC);
        btResetar = (Button)findViewById(R.id.btnResetar);
        txResultado = (TextView)findViewById(R.id.txtResultadoIMC);
    }
}