package com.example.mobile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobile.R;
import com.example.mobile.storage.SharedPreferenceMan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private TextView textViewCategory, textViewTitle,textViewDesc, textViewNumber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewCategory = view.findViewById(R.id.textViewCategory2);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewDesc = view.findViewById(R.id.textViewDesc);
        textViewNumber = view.findViewById(R.id.textViewNumber);

        textViewCategory.setText(SharedPreferenceMan.getInstance(getActivity()).getAnnonce().getCategory());
        textViewTitle.setText(SharedPreferenceMan.getInstance(getActivity()).getAnnonce().getTitle());
        textViewDesc.setText(SharedPreferenceMan.getInstance(getActivity()).getAnnonce().getDescription());
        textViewNumber.setText(SharedPreferenceMan.getInstance(getActivity()).getAnnonce().getNumber());
    }
}