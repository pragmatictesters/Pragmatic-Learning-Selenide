package com.pragmatic.selenide;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTestBase {


    @BeforeSuite(groups = {"smoke"})
    public void beforeSuiteSmoke(){
        setUp();
    }


    @BeforeSuite(groups = {"regression"})
    public void beforeSuiteRegression(){
        setUp();
    }



    private void setUp() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl ="https://hrm.pragmatictestlabs.com";
        Configuration.startMaximized= true;
        Configuration.headless = false;
        Configuration.timeout= 30000;
    }


    @BeforeMethod(groups = {"smoke"})
    public void beforeMethodSmoke(){
        open("/");
    }

    @BeforeMethod(groups = {"regression"})
    public void beforeMethodRegression(){
        open("/");
    }




}
