package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Etapa5Activity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    Button btVoltar, btAvancar;
    TextView txDesc;
    public TextToSpeech leitura; //    para ler a descrição das etapas e obs.
    public Locale locale; //           voz
    MediaPlayer som;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etapa5);

        btAvancar = (Button)findViewById(R.id.btnE5Avanc);
        btVoltar = (Button)findViewById(R.id.btnE5Voltar);
        txDesc = (TextView)findViewById(R.id.txtEtapa5);
        leitura = new TextToSpeech(Etapa5Activity.this, Etapa5Activity.this);

        botoes();

        timerMsg(10000);
    }
    public void botoes(){
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volta = new Intent(Etapa5Activity.this, Etapa4Activity.class);
                startActivity(volta);
                som.stop();
            }
        });
        btAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avanc = new Intent(Etapa5Activity.this, Etapa6Activity.class);
                startActivity(avanc);
                som.stop();
            }
        });
    }

    public void timerMsg(int tempo){
        String texto = txDesc.getText().toString();
        leitura.speak(texto, TextToSpeech.QUEUE_FLUSH,Bundle.EMPTY,"3");
        new CountDownTimer(tempo, 1000) {
            public void onTick(long millisUntilFinished) {
                if (som == null){
                    som = MediaPlayer.create(Etapa5Activity.this, R.raw.timer);
                }
                som.start();
            }
            public void onFinish() {
                Intent avanc = new Intent(Etapa5Activity.this, Etapa6Activity.class);
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