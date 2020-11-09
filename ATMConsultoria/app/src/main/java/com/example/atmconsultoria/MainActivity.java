package com.example.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servico, R.id.nav_clientes, R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        // Realizar uma pré chamada de telefone
        // String celular = "tel: 119996352894";
        // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        // startActivity(intent);

        // Exibir uma imagem
        //String imagem = "https://spguia.melhoresdestinos.com.br/system/fotos_local/fotos/43446/show/praia-da-bombaca.jpg";
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        // startActivity(intent);

         // Exibir um local no maps
         // String endereco = "https://goo.gl/maps/UPzufeQNq2SbUFTe9";
         // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));
         // startActivity(intent);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"cassio.fogarin@gmail.com"}); // poderia usar mais emails como destinatário colocando nas posições do array
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo ATM Consultoria");
        intent.putExtra(Intent.EXTRA_TEXT, "Compartilhar");
        intent.setType("message/rfc822");
        // intent.setType("text/plain"); // Convoca apps para mensagens de texto padrão
        // intent.setType("image/*"); // Convoca apps para imagens de qualquer formato (image/jpg seria apenas para jpg)
        // mime-types-complete-list para a listagem completa
        startActivity(Intent.createChooser(intent, "Compartilhar"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}