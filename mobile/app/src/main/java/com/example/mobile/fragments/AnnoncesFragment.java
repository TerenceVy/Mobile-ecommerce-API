package com.example.mobile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobile.R;
import com.example.mobile.adapters.AnnoncesAdapter;
import com.example.mobile.api.RetrofitClient;
import com.example.mobile.models.Annonce;
import com.example.mobile.models.AnnoncesResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnnoncesFragment extends Fragment {

    private RecyclerView recyclerView;
    private AnnoncesAdapter adapter;
    private List<Annonce> annonceList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.annonces_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<AnnoncesResponse> call = RetrofitClient.getInstance().getApi().getAnnonces();

        call.enqueue(new Callback<AnnoncesResponse>() {
            @Override
            public void onResponse(Call<AnnoncesResponse> call, Response<AnnoncesResponse> response) {

                annonceList = new ArrayList<>();
                annonceList = response.body().getAnnonces();
                RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(mLayoutManager1);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                adapter = new AnnoncesAdapter(getActivity(), annonceList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<AnnoncesResponse> call, Throwable t) {

            }
        });

    }
}