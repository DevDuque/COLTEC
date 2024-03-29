package com.example.coltec;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        TextView nameView = (TextView) findViewById(R.id.name_label);

        // Getting the data inside the Bundle
        Intent intent = getIntent();

        Bundle args = intent.getExtras();
        String userName = args.getString("nome");
        nameView.setText("Olá, " + userName + "!");

        TextView welcomeLabel = (TextView) findViewById(R.id.welcome_label);
    }
}