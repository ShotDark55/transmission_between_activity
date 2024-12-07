package com.okiyacode.transmission_between_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText username;
    private EditText password;
    private Context context;

    private void setup() {
        login = findViewById(R.id.loginID);
        username = findViewById(R.id.usernameID);
        password = findViewById(R.id.passwordID);
        context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();

        login.setOnClickListener(v -> {
            String userText = username.getText().toString();
            String passText = password.getText().toString();

            if(userText.isEmpty() || passText.isEmpty()) {
                Toast.makeText(context, "please add user and password ",Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(context, MainActivity2.class);
                startActivity(intent);
            }

        });

    }
}