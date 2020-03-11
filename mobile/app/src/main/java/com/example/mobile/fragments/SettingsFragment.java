package com.example.mobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mobile.R;
import com.example.mobile.activities.AddAnnonceActivity;
import com.example.mobile.activities.LoginActivity;


import com.example.mobile.activities.ProfileActivity;
import com.example.mobile.storage.SharedPreferenceMan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SettingsFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.buttonLogout).setOnClickListener(this);
        view.findViewById(R.id.buttonAnnonces).setOnClickListener(this);

    }


    private void logout() {
        SharedPreferenceMan.getInstance(getActivity()).clear();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogout:
                logout();
                break;
        }
    }
}