package com.pragmatic.selenide.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;


// PTL
public class TestBase {

    @BeforeSuite
    public void beforeSuite(){
        Configuration.baseUrl= "http://hrm.pragmatictestlabs.com/";
    }

    @BeforeMethod
    public void beforeMethod(){
        open("/");
    }

}
