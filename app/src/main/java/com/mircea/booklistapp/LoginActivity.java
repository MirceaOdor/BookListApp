package com.mircea.booklistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private EditText user;
    private EditText password;

    private String Username = "Admin";
    private String UserPassword = "12345";
    boolean isValid = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.etUser);
        password = findViewById(R.id.etPassword);

        login = (Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String inputUser = user.getText().toString();
                String inputPassword = password.getText().toString();

                if (inputUser.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill both", Toast.LENGTH_SHORT).show();
                } else {
                    isValid = validate(inputUser, inputPassword);
                    if (!isValid) {
                        Toast.makeText(LoginActivity.this, "Wrong User/Password", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(String name, String password) {
        return name.equals(Username) && password.equals(UserPassword);
    }
}