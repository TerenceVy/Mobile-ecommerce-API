package com.example.mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile.R;
import com.example.mobile.api.RetrofitClient;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAnnonceActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextCategory ;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextPrice;
    private EditText editTextNumber;

    private void addAnnonce() {

        String category = editTextCategory.getText().toString().trim();
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        Integer price = Integer.valueOf(editTextPrice.getText().toString());
        String number = editTextNumber.getText().toString().trim();
        String user_id = "1";
        if(category.isEmpty()||title.isEmpty()||description.isEmpty()||number.isEmpty())
        {
            editTextCategory.setError("Veuillez remplir tous les champs");
            editTextCategory.requestFocus();
            return;
        }

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .addannonce(category,title,description,price,number,user_id);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String str = response.body().string();
                    Toast.makeText(AddAnnonceActivity.this, str, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(AddAnnonceActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch ((view.getId())){
            case R.id.buttonAjouter:
                addAnnonce();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addannonce);

        editTextCategory = findViewById(R.id.editTextCategory);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextPrice = findViewById(R.id.editTextPrice);
        editTextNumber = findViewById(R.id.editTextNumber);

        findViewById(R.id.buttonAjouter).setOnClickListener(this);

    }
}
