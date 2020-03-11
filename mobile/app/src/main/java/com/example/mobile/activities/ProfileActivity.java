package com.example.mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mobile.R;
import com.example.mobile.fragments.HomeFragment;
import com.example.mobile.fragments.SettingsFragment;
import com.example.mobile.fragments.AnnoncesFragment;
import com.example.mobile.storage.SharedPreferenceMan;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

        displayFragment(new HomeFragment());

    }

/*
    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPreferenceMan.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }*/

    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch(item.getItemId()){
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_annonces:
                fragment = new AnnoncesFragment();
                break;
            case R.id.menu_settings:
                fragment = new SettingsFragment();
                break;
        }

        if(fragment != null){
            displayFragment(fragment);
        }

        return false;
    }
}
