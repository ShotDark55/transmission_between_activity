package com.okiyacode.transmission_between_activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    Context context;
    TextView screen;
    Button btnLoad;


    private void setup() {
        context = this;
        screen = findViewById(R.id.textViewID);
        btnLoad = findViewById(R.id.buttonLoad);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            setup();

            btnLoad.setOnClickListener(View -> {

                Bundle bundle = getIntent().getExtras();
                String result = "";
                if (bundle!=null) {
                    String user = bundle.getString("userKey");
                    String pass = bundle.getString("passKey");
                    result = "Username : " .concat(user) + "\nPassword : " .concat(pass);
                }else {
                    Toast.makeText(context,"no data found !",Toast.LENGTH_SHORT).show();
                }

                screen.setText(result);

            });

        }


    }
