package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoActivity extends AppCompatActivity {

    ImageButton imVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imVideo = (ImageButton)findViewById(R.id.imgVideo);
        imVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/UyVh7qldqXA"));
                startActivity(viewIntent);
            }
        });
        //fonte das informaçãos do alongamento, que serão adaptadas para o aplicativo
    }
}