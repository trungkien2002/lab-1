package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class LoginEmail extends AppCompatActivity {

    TextView tvSignUp;
    EditText edtUsername, edtPassword;

    MaterialButton btn_login;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_email);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvSignUp = findViewById(R.id.tvSignUp);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btn_login = findViewById(R.id.btn_login);

        tvSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(LoginEmail.this, SignUp.class);
            startActivity(intent);
        });

        auth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(view -> {
           String username = edtUsername.getText().toString();
           String password = edtPassword.getText().toString();
           auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
               if(task.isSuccessful()){
                   Toast.makeText(LoginEmail.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(LoginEmail.this, LogOut.class);
                   startActivity(intent);
               }
           }).addOnFailureListener(e -> {
               Toast.makeText(LoginEmail.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
           });
        });
    }
}