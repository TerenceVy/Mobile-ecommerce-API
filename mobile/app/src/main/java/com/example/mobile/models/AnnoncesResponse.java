package com.example.mobile.models;

import java.util.List;

public class AnnoncesResponse {

    private boolean error;
    private List<Annonce> annonces;

    public AnnoncesResponse(boolean error, List<Annonce> annonces) {
        this.error = error;
        this.annonces = annonces;
    }

    public boolean isError() {
        return error;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }
}
