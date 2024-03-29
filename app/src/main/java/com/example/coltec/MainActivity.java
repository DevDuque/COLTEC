package com.example.coltec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Logo & Label
        ImageView logoColtec = (ImageView) findViewById(R.id.coltec_logo);
        TextView loginLabel = (TextView) findViewById(R.id.login_label);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(onClickLogin());

        TextView noAccessLink = (TextView) findViewById(R.id.no_access);
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pegando os campos de preenchimento
                TextView txtLogin = (TextView) findViewById(R.id.login_input);
                TextView txtSenha = (TextView) findViewById(R.id.password);

                // Salvando esses dados que foram retornados dos respectivos campos
                String login = txtLogin.getText().toString();
                String senha = txtSenha.getText().toString();

                // Fazendo um condicional para logar
                if (login.equals("Duque") && senha.equals("coltec")) {
                    //Navega para a próxima tela
                    Intent intent = new Intent(getBaseContext(), HomePageActivity.class);

                    // Cria o bundle e o insere na nova Intent
                    Bundle params = new Bundle();
                    params.putString("nome", txtLogin.getText().toString());
                    intent.putExtras(params);

                    startActivity(intent); //navega para a próxima tela
                } else { //Mostra mensagem de login incorreto
                    alert("Login ou senha incorretos");
                }
            }
        };
    }
}