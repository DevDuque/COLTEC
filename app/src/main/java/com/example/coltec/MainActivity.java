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

    private ImageView logoColtec;

    private TextView loginLabel;
    private EditText loginInput;
    private EditText passwordInput;
    private Button loginButton;
    private TextView noAccessLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Logo & Label
        logoColtec = findViewById(R.id.coltec_logo);
        loginLabel = findViewById(R.id.login_label);

        // Form
        loginInput = findViewById(R.id.login_input);
        passwordInput = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        noAccessLink = findViewById(R.id.no_access);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginStr = loginInput.getText().toString();
                String passwordStr = passwordInput.getText().toString();

                // Conditional to Login
                if(loginStr.equals("2023954724") && passwordStr.equals("duque123")) {

                    // Creating the navigation
                    Intent intent = new Intent(getBaseContext(), HomePageActivity.class);

                    // Create bundle to get the text for the next page
                    Bundle params = new Bundle();
                    params.putString("name", loginStr);
                    intent.putExtras(params);

                    // Navigate to the next page
                    startActivity(intent);
                } else {
                    alert("Login ou senha incorretos! Tente novamente.");
                }
            }
        });
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


}