package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView imageMoeda;
    private Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imageMoeda = findViewById(R.id.imageMoeda);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        // Dados Recuperados
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");

        // Setando moeda
        if (numero == 0) {
            imageMoeda.setImageResource(R.drawable.moeda_cara);
        } else {
            imageMoeda.setImageResource(R.drawable.moeda_coroa);
        }

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}