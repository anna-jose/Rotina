package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Etapa1Activity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    Button btAvancar;
    TextView txDesc;
    public TextToSpeech leitura; //    para ler a descrição das etapas e obs.
    public Locale locale; //           voz
    MediaPlayer som;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etapa1);

        btAvancar = (Button)findViewById(R.id.btnE1Avanc);
        txDesc = (TextView)findViewById(R.id.txtEtapa1);
        leitura = new TextToSpeech(Etapa1Activity.this, Etapa1Activity.this);

        botoes();



        timerMsg(10000);
    }

    public void botoes(){
        btAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avanc = new Intent(Etapa1Activity.this, Etapa2Activity.class);
                startActivity(avanc);
                som.stop();
            }
        });
    }

    public void timerMsg(int tempo){
        String texto = txDesc.getText().toString();
        leitura.speak(texto, TextToSpeech.QUEUE_FLUSH,Bundle.EMPTY,"1");
        new CountDownTimer(tempo, 1000) {
            public void onTick(long millisUntilFinished) {
                if (som == null){
                    som = MediaPlayer.create(Etapa1Activity.this, R.raw.timer);
                }
                som.start();
            }
            public void onFinish() {
                Intent avanc = new Intent(Etapa1Activity.this, Etapa2Activity.class);
                startActivity(avanc);
                som.stop();
            }
        }.start();
    }

    @Override
    public void onInit(int status) {
        locale = new Locale("pt", "BR");
        leitura.setLanguage(locale);
    }
}