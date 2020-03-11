package com.example.mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile.R;
import com.example.mobile.api.RetrofitClient;
import com.example.mobile.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        findViewById(R.id.buttonLogin).setOnClickListener(this);
        findViewById(R.id.textViewRegister).setOnClickListener(this);
    }




    private void Login()
    {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(password.isEmpty())
        {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
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

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .Login(email, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (!loginResponse.isError()) {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();


                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch ((view.getId())){
            case R.id.buttonLogin:
                Login();
                break;
            case R.id.textViewRegister:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
