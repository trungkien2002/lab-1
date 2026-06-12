package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton mtrb_loginemail, mtrb_loginphone;

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

        mtrb_loginemail = findViewById(R.id.mtrb_loginemail);
        mtrb_loginphone = findViewById(R.id.mtrb_loginphone);

        mtrb_loginemail.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginEmail.class);
            startActivity(intent);
        });

        mtrb_loginphone.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginPhone.class);
            startActivity(intent);
        });
    }
}