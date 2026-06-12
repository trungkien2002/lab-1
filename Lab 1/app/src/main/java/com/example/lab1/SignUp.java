package com.example.lab1;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    ImageView btnBack;

    EditText edtUsername, edtPassword;

    MaterialButton btn_signup;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btn_signup = findViewById(R.id.btn_signup);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this, LoginEmail.class);
            startActivity(intent);
        });

        auth = FirebaseAuth.getInstance();

        btn_signup.setOnClickListener(view -> {

            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    FirebaseUser user = auth.getCurrentUser();
                    Toast.makeText(SignUp.this, "Đăng ký thành công", LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, LoginEmail.class);
                    startActivity(intent);
                }
            }).addOnFailureListener(e -> {
                Toast.makeText(SignUp.this, "Đăng ký thất bại", LENGTH_SHORT).show();
            });
        });





    }
}