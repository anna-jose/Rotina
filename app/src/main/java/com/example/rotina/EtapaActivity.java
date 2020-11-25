package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class EtapaActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    Button btVoltar, btAvancar;
    TextView txEtapa, txDescricao;
    ImageView imIlustra;
    public Integer contador = 0; //gerencia qual etapa será exibida
    private TextToSpeech leitura; //para ler a descrição das etapas e obs.
    private Locale locale; //voz
    MediaPlayer tick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etapa);
        leitura = new TextToSpeech(EtapaActivity.this, EtapaActivity.this);
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
            txDescricao.setText("Deitado, coloque um calcanhar quase em cima de um joelho.\n\nSegure pelo outro lado do joelho e fique assim por 20 segundos.");
//            String texto = txDescricao.getText().toString();
            ler();
        }else if (contador == 1){
            txEtapa.setText("Etapa 2 - Coluna 1");
            imIlustra.setImageResource(R.drawable.coluna1);
            txDescricao.setText("Torça uma perna sobre a outra. Mantenha a coluna reta e braços abertos.\n\nAguarde 20 segundos.");
//            String texto = txDescricao.getText().toString();
            ler();
            timer();
        }else if (contador == 2){
            txEtapa.setText("Etapa 3 - Coluna 2");
            imIlustra.setImageResource(R.drawable.coluna2a);
            txDescricao.setText("Vire de barriga para baixo, e empurre com as duas mãos, braços esticados e quadril deitado.");
            ler();
        }else if (contador == 3){
            txEtapa.setText("Etapa 4 - Coluna 3");
            imIlustra.setImageResource(R.drawable.coluna2b);
            txDescricao.setText(" Agora, dobre os joelhos e deite sobre eles, apoiando a cabeça na cama.");
            ler();
        }else if (contador == 4){
            txEtapa.setText("Etapa 5 - Braços 1");
            imIlustra.setImageResource(R.drawable.bracos1);
            txDescricao.setText("Sente e cruze as pernas. Apoie um braço do seu lado e alongue o outro para a mesma direção.\n\nMantenha o braço alongado no ar. ");
            ler();
        }else if (contador == 5){
            txEtapa.setText("Etapa 6 - Pescoço");
            imIlustra.setImageResource(R.drawable.pescoco);
            txDescricao.setText("Relaxe e gire a cabeça em movimentos circulares, cuidadosamente. Tente o sentido horário e antihorário!");
            ler();
        }else if (contador == 6){
            txEtapa.setText("Etapa 7 - Braços 2");
            imIlustra.setImageResource(R.drawable.bracos2);
            txDescricao.setText("Estique os braços acima da cabeça.\n\nEntrelace os dedos por 20 segundos.");
            ler();
        }
    }

    public void ler(){ //lê os bagulho
        String texto = txDescricao.getText().toString();
        leitura.speak(texto, TextToSpeech.QUEUE_FLUSH,Bundle.EMPTY,"1");
    }

    public void timer(){

        //setar o som do timer
        if (tick == null){
            tick = MediaPlayer.create(EtapaActivity.this, R.raw.timer);
//            tick.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    stopPlayer();
//                }
//            });
        }
        tick.setLooping(true); //faz o loop to som
        tick.start();

    }

    private void stopPlayer() {
        if (tick != null) {
            tick.release();
            tick = null;
        }
    }

    @Override
    public void onInit(int status) {
        locale = new Locale("pt", "BR");
        leitura.setLanguage(locale);
    }
}