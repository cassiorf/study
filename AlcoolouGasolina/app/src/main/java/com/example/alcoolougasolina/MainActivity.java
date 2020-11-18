package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText precoAlcool, precoGasolina;
    private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAlcool);
        precoGasolina = findViewById(R.id.precoGasolina);
        textoResultado = findViewById(R.id.textoResultado);
    }

    public void calcularPreco(View view) {
        if (validarCampos(precoAlcool.getText().toString(), precoGasolina.getText().toString())) {
            if ((Double.parseDouble(precoAlcool.getText().toString()) / Double.parseDouble(precoGasolina.getText().toString())) >= 0.7)
                textoResultado.setText("Gasolina é melhor!");
            else
                textoResultado.setText("Álcool é melhor!");
        } else {
            textoResultado.setText("Preencha todos os campos!");
        }
    }

    public Boolean validarCampos(String precoAlcool, String precoGasolina) {
        if (precoAlcool.equals("") || precoGasolina.equals("") || precoAlcool == null || precoGasolina == null) {
            return false;
        } else
            return true;
    }
}