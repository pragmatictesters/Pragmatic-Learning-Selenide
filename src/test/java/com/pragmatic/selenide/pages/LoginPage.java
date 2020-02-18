package com.pragmatic.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Pragmatic Test Labs
 * @Author Janesh Kodikara
 *
 */
public class LoginPage {


    private SelenideElement txtUsername = $("input#txtUsername");
    private SelenideElement txtPassword = $("input#txtPassword");
    private SelenideElement btnLogin = $("input#btnLogin");
    private SelenideElement msgError = $("span#spanMessage");

    public LoginPage typeUsername(String username) {
        txtUsername.setValue(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        txtPassword.setValue(password);
        return this;
    }


    public LoginPage clickLoginError(){
        btnLogin.click();
        return this;
    }

    public LandingPage clickLoginSuccess(){
        btnLogin.click();
        return new LandingPage();
    }

    public SelenideElement getError(){
        return msgError;
    }

}
