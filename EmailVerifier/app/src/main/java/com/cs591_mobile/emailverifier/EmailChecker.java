package com.cs591_mobile.emailverifier;

public class EmailChecker {

    public EmailChecker() {
    }
    public boolean checkEmail(String email){
        return email.contains("@");
    }
}
