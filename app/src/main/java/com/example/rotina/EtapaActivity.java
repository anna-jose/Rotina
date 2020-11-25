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
        if (contador < 0 || contador > 6){ //funcionou ;-;
            Intent voltar = new Intent(EtapaActivity.this, MainActivity.class);
            startActivity(voltar);
        }else if (contador == 0){
            txEtapa.setText("Etapa 1 - Joelhos");
            imIlustra.setImageResource(R.drawable.joelho);
            txDescricao.setText("Deitado, coloque um calcanhar quase em cima do joelho da outra perna, ainda visível à você. \n\nSegure esta perna pelo outro lado e fique assim por 20 segundos.");
        }else if (contador == 1){
            txEtapa.setText("Etapa 2 - Coluna 1");
            imIlustra.setImageResource(R.drawable.coluna1);
            txDescricao.setText("Torça uma perna sobre a outra. Mantenha a coluna reta e braços abertos. \n\nAguarde 20 segundos.");
        }else if (contador == 2){
            txEtapa.setText("Etapa 3 - Coluna 2");
            imIlustra.setImageResource(R.drawable.coluna2a);
            txDescricao.setText("Vire de barriga para baixo, e empurre com as duas mãos, braços esticados e quadril deitado.");
        }else if (contador == 3){
            txEtapa.setText("Etapa 4 - Coluna 3");
            imIlustra.setImageResource(R.drawable.coluna2b);
            txDescricao.setText(" Agora, dobre os joelhos e deite sobre eles, apoiando a cabeça na cama.");
        }else if (contador == 4){
            txEtapa.setText("Etapa 5 - Braços 1");
            imIlustra.setImageResource(R.drawable.bracos1);
            txDescricao.setText("Sente e cruze as pernas. Apoie um braço do seu lado e alongue o outro para a mesma direção. \n\nMantenha o braço alongado no ar. ");
        }else if (contador == 5){
            txEtapa.setText("Etapa 6 - Pescoço");
            imIlustra.setImageResource(R.drawable.pescoco);
            txDescricao.setText("Relaxe e gire a cabeça em movimentos circulares, cuidadosamente. Tente o sentido horário e antihorário!");
        }else if (contador == 6){
            txEtapa.setText("Etapa 7 - Braços 2");
            imIlustra.setImageResource(R.drawable.bracos2);
            txDescricao.setText("Estique os braços acima da cabeça, entrelace os dedos por 20 segundos.");
        }
    }
}