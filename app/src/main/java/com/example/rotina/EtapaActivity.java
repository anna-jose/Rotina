package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EtapaActivity extends AppCompatActivity {

    Button btVoltar, btAvancar;
    TextView txEtapa, txDescricao;
    ImageView imIlustra;
    public Integer contador = 0; //gerencia qual etapa será exibida

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etapa);
        carregaWidgets();
        botoes();
        carregaEtapa();
    }

    public void carregaWidgets(){
        //Navegação
        btVoltar = (Button)findViewById(R.id.btnVoltar);
        btAvancar = (Button)findViewById(R.id.btnAvancar);
        //Estrutura da Etapa
        txEtapa = (TextView)findViewById(R.id.txtEtapa);
        txDescricao = (TextView)findViewById(R.id.txtDescricao);
        imIlustra = (ImageView)findViewById(R.id.imgIlustra);
    }

    public void botoes(){
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador--;
                Toast.makeText(EtapaActivity.this, "Contador = " + contador, Toast.LENGTH_SHORT).show();
                carregaEtapa();
            }
        });
        btAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                Toast.makeText(EtapaActivity.this, "Contador = " + contador, Toast.LENGTH_SHORT).show();
                carregaEtapa();
            }
        });
    }

    public void carregaEtapa(){
        if (contador < 0 || contador > 4){ //funcionou ;-;
            Intent voltar = new Intent(EtapaActivity.this, MainActivity.class);
            startActivity(voltar);
        }else if (contador == 0){
            txEtapa.setText("Etapa 1");
        }else if (contador == 1){
            txEtapa.setText("Etapa 2");
        }else if (contador == 2){
            txEtapa.setText("Etapa 3");
        }else if (contador == 3){
            txEtapa.setText("Etapa 4");
        }else if (contador == 4){
            txEtapa.setText("Etapa 5 - FINAL");
        }
    }
}