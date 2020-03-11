package com.example.mobile.models;

public class User {

    private int id;
    private String email,login;

    public User(int id, String email, String login)
    {
        this.id = id;
        this.email = email;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }
}
