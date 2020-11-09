package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView resultadoJogo = findViewById(R.id.resultadoJogo);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        System.out.println("Opção usuário: " + escolhaUsuario);
        System.out.println("Opção app: " + opcoes[numero]);

        if (
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra")
        ) {
            resultadoJogo.setText("Vitória do APP!");
        } else if (
                (escolhaApp == "pedra" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "pedra")
        ) {
            resultadoJogo.setText("Vitória do usuário!");
        } else {
            resultadoJogo.setText("Empate");
        }
    }
}