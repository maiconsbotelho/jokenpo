package br.com.maiconbotelho.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageVoce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageVoce = findViewById(R.id.imageViewVoce);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
        imageVoce.setImageResource(R.drawable.pedra);
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
        imageVoce.setImageResource(R.drawable.papel);
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
        imageVoce.setImageResource(R.drawable.tesoura);
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageApp = findViewById(R.id.imageViewApp);
        TextView textResultado = findViewById(R.id.textViewResultado);

        int x = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel","tesoura"};
        String escolhaApp = opcoes[x];

        switch (escolhaApp){
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageApp.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){ //App ganhador
            textResultado.setText("Você perdeu :(");

        }else if (
                 (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                 (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                 (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ) { //Usuario Ganhador
            textResultado.setText("Você ganhou :)");

        }else { //Empate
            textResultado.setText("Empatamos");
        }
    }
}