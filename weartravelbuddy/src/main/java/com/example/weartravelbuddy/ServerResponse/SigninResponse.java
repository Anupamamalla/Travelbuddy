package com.example.weartravelbuddy.ServerResponse;

public class SigninResponse {
    private String token;
    private String success;


    public SigninResponse(String token, String success) {
        this.token = token;
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
