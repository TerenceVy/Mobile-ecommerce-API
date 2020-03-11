package com.example.mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import retrofit2.Call;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile.R;
import com.example.mobile.api.RetrofitClient;

import java.io.*;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextLogin;


    private void userRegister(){

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String login = editTextLogin.getText().toString().trim();

        if(password.isEmpty())
        {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length() < 8)
        {
            editTextPassword.setError("Password must have more than 8 characters");
            editTextPassword.requestFocus();
            return;
        }

        if(login.isEmpty())
        {
            editTextLogin.setError("Login is required");
            editTextLogin.requestFocus();
            return;
        }

        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Email a valid email address");
            editTextEmail.requestFocus();
            return;
        }

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .register(login,email,password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String str = response.body().string();
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch ((view.getId())){
            case R.id.buttonRegister:
                userRegister();
                break;
            case R.id.textViewLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.buttonAnnonces:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.buttonaddAnnonce:
                startActivity(new Intent(this,AddAnnonceActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextLogin = findViewById(R.id.editTextLogin);

        findViewById(R.id.buttonRegister).setOnClickListener(this);
        findViewById(R.id.textViewLogin).setOnClickListener(this);
        findViewById(R.id.buttonAnnonces).setOnClickListener(this);
        findViewById(R.id.buttonaddAnnonce).setOnClickListener(this);
    }
}
