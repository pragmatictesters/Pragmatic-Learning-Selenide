package com.pragmatic.selenide;


import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.pragmatic.selenide.util.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HRMTestBase {

    public static  Faker faker = new Faker();

    @BeforeSuite(groups = {"smoke"})
    public void beforeSuiteSmoke() {
        setUp();
    }


    @BeforeSuite(groups = {"regression"})
    public void beforeSuiteRegression() {
        setUp();
    }


    private void setUp() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://hrm.pragmatictestlabs.com";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.timeout = 30000;
    }


    @BeforeMethod(groups = {"smoke"})
    public void beforeMethodSmoke() {
        open("/");
    }

    @BeforeMethod(groups = {"regression"})
    public void beforeMethodRegression() {
        open("/");
    }


    public void login() {
        $("#txtUsername").setValue(Constants.ADMIN_USERNAME);
        $("#txtPassword").setValue(Constants.ADMIN_PASSWORD);
        $("#btnLogin").click();
        $("#welcome").shouldHave(exactText("Welcome Admin"));
    }


}
