package com.example.travelbuddyapps.Model;

public class User {
    private String email;
    private String username;
    private String country;
    private String password;
    public User(String username,String password) {

        this.username = username;

        this.password = password;
    }

    public User(String email, String username, String country, String password) {
        this.email = email;
        this.username = username;
        this.country = country;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
