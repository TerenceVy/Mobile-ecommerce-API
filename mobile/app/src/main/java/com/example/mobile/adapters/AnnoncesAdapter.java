package com.example.mobile.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobile.R;
import com.example.mobile.models.Annonce;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnnoncesAdapter extends RecyclerView.Adapter<AnnoncesAdapter.AnnoncesViewHolder> {

    private Context mCtx;
    private List<Annonce> annonceList;

    public AnnoncesAdapter(Context mCtx, List<Annonce> userList) {
        this.mCtx = mCtx;
        this.annonceList= annonceList;
    }

    @NonNull
    @Override
    public AnnoncesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false);
        return new AnnoncesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnoncesViewHolder holder, int position) {
        Annonce annonce = annonceList.get(position);

        holder.textViewCategory.setText(annonce.getCategory());
        holder.textViewTitle.setText(annonce.getTitle());
        holder.textViewDesc.setText(annonce.getDescription());
        holder.textViewNumber.setText(annonce.getNumber());
    }

    @Override
    public int getItemCount() {
        return annonceList.size();
    }

    class AnnoncesViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCategory, textViewTitle,textViewDesc,textViewNumber;

        public AnnoncesViewHolder(View itemView) {
            super(itemView);

            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewNumber = itemView.findViewById(R.id.textViewNumber);

        }
    }
}
