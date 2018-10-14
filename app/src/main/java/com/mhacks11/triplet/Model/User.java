package com.mhacks11.triplet.Model;

public class User {

    private String username;
    private String email;
    private String password;
    private int elo;

    public User(){

    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        elo = 2000;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getElo() {
        return elo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }
}
