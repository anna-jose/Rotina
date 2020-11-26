package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class EtapaActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    //  LISTA
    //Button btE1, btE2, btE3, btE4, btE5, btE6, btE7;
    //  LAYOUT
    TextView txEtapa, txDescricao;
    ImageView imIlustra;
    //  TTS
    public Integer contador = 0; //     gerencia qual etapa será exibida
    private TextToSpeech leitura; //    para ler a descrição das etapas
    private Locale locale; //           voz
    MediaPlayer som;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etapa);

        carregaWidgets();
        carregaEtapa(0);
    }



    //WIDGETS OK - confio
    public void carregaWidgets(){
        //Estrutura da Etapa
        txEtapa = (TextView)findViewById(R.id.txtEtapa);
        txDescricao = (TextView)findViewById(R.id.txtDescricao);
        imIlustra = (ImageView)findViewById(R.id.imgIlustra);

        leitura = new TextToSpeech(EtapaActivity.this, EtapaActivity.this);
    }

    public void carregaEtapa(int contador){
        if (contador == 0){
            txEtapa.setText("Etapa 1 - Joelhos");
            imIlustra.setImageResource(R.drawable.joelho);
            txDescricao.setText("Deitado, coloque um calcanhar quase em cima de um joelho.\n\nSegure pelo outro lado do joelho e aguarde.");
            timerMsg(10000, txDescricao.getText().toString());//, "Repita com a outra perna.");

        }else if (contador == 1){

            txEtapa.setText("Etapa 2 - Coluna 1");
            imIlustra.setImageResource(R.drawable.coluna1);
            txDescricao.setText("Torça uma perna sobre a outra. Mantenha a coluna reta e braços abertos.\n\nAguarde.");
            timerMsg(10000, txDescricao.getText().toString());//, "Repita com a outra perna.");

        }else if (contador == 2){

            txEtapa.setText("Etapa 3 - Coluna 2");
            imIlustra.setImageResource(R.drawable.coluna2a);
            txDescricao.setText("Vire de barriga para baixo, e empurre com as duas mãos, braços esticados e quadril deitado.");
            timerMsg(10000, txDescricao.getText().toString());

        }else if (contador == 3){

            txEtapa.setText("Etapa 4 - Coluna 3");
            imIlustra.setImageResource(R.drawable.coluna2b);
            txDescricao.setText("Agora, dobre os joelhos e deite sobre eles, apoiando a cabeça na cama.");
            timerMsg(10000, txDescricao.getText().toString());

        }else if (contador == 4){

            txEtapa.setText("Etapa 5 - Braços 1");
            imIlustra.setImageResource(R.drawable.bracos1);
            txDescricao.setText("Sente e cruze as pernas. Apoie um braço do seu lado e alongue o outro para a mesma direção.\n\nMantenha o braço alongado no ar.");
            timerMsg(10000, txDescricao.getText().toString());

        }else if (contador == 5){

            txEtapa.setText("Etapa 6 - Pescoço");
            imIlustra.setImageResource(R.drawable.pescoco);
            txDescricao.setText("Relaxe e gire a cabeça em movimentos circulares, cuidadosamente. Tente o sentido horário e antihorário!");
            timerMsg(10000, txDescricao.getText().toString());

        }else if (contador == 6){

            txEtapa.setText("Etapa 7 - Braços 2");
            imIlustra.setImageResource(R.drawable.bracos2);
            txDescricao.setText("Estique os braços acima da cabeça e entrelace os dedos.");
            timerMsg(10000, txDescricao.getText().toString());

        }else if(contador < 0 || contador > 6){ //funcionou ;-;
            Intent voltar = new Intent(EtapaActivity.this, MainActivity.class);
            startActivity(voltar);
        }
    }

    public void timerMsg(int tempo, final String msg1) {
        leitura.speak(msg1, TextToSpeech.QUEUE_FLUSH, Bundle.EMPTY, "1");

        CountDownTimer cdt = new CountDownTimer(tempo, 1000) {
            public void onTick(long millisUntilFinished) {
                if (som == null) {
                    som = MediaPlayer.create(EtapaActivity.this, R.raw.timer);
                }
                som.start();
            }

            public void onFinish() {
                contador++;
                carregaEtapa(contador);
            }
        }.start();
    }

//    public void tts(String msg){
//        leitura.speak(msg, TextToSpeech.QUEUE_FLUSH,Bundle.EMPTY,"1");
//    }

    @Override //OK
    public void onInit(int status) {
        locale = new Locale("pt", "BR");
        leitura.setLanguage(locale);
    }

}