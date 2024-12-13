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
            Intent intent = new Intent(context, MainActivity2.class);
            Bundle bundle = new Bundle();

            if (!userText.isEmpty()) {

                bundle.putString("userKey",userText);

                if (!passText.isEmpty()) {
                        if (passText.length() >= 8) {

                            bundle.putString("passKey",passText);
                            intent.putExtras(bundle);

                            startActivity(intent);
                        }else {
                            Toast.makeText(context,"min 8 char required ! ",Toast.LENGTH_SHORT).show();
                        }

                }else {
                    Toast.makeText(context,"please add password required filed !",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(context,"please add username required filed !",Toast.LENGTH_SHORT).show();
            }

        });

    }
}