package com.pragmatic.selenide;


import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.pragmatic.selenide.util.Constants;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Pragmatic Test Labs
 * @Author Janesh Kodikara
 *
 */
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

    /**
     * Supported Browsers (values) : "chrome", "firefox", "legacy_firefox" (upto ESR 52), "ie", "opera", "edge"
     * Default value: "chrome"
     *
     *
     */
    private void setUp() {

        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://hrm.pragmatictestlabs.com";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen= false;
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
      login(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD);
    }


    public void login(String username, String password) {
        $("#txtUsername").setValue(username);
        $("#txtPassword").setValue(password);
        $("#btnLogin").click();
    }


    public void logout(){
        $("#welcome").click();
        $(By.xpath("//a[contains(text(),'Logout')]")).click();
    }


}
