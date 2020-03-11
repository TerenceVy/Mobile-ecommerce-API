package com.example.mobile.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mobile.models.Annonce;
import com.example.mobile.models.User;

public class SharedPreferenceMan {

    private static final String SHARED_PREF_NAME = "my_shared_preff";

    private static SharedPreferenceMan mInstance;
    private Context mCtx;

    private SharedPreferenceMan(Context mCtx) {
        this.mCtx = mCtx;
    }


    public static synchronized SharedPreferenceMan getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPreferenceMan(mCtx);
        }
        return mInstance;
    }


    public void saveUser(User user) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", user.getId());
        editor.putString("email", user.getEmail());
        editor.putString("name", user.getLogin());

        editor.apply();

    }


    public void saveAnnonce(Annonce annonce) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("category", annonce.getCategory());
        editor.putString("title", annonce.getTitle());
        editor.putString("description", annonce.getDescription());
        editor.putInt("price", annonce.getPrice());
        editor.putString("number", annonce.getNumber());

        editor.apply();

    }
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }

    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("login", null)
        );
    }

    public Annonce getAnnonce() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Annonce(
                sharedPreferences.getString("category", null),
                sharedPreferences.getString("title", null),
                sharedPreferences.getString("description", null),
                sharedPreferences.getInt("price", 0),
                sharedPreferences.getString("number", null)

        );
    }
    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
