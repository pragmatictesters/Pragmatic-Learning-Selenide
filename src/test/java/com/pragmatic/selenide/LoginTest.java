package com.pragmatic.selenide;


import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest  extends SelenideTestBase{


    @Test(groups = {"smoke", "regression"})
    public void testValidUserLogin(){
        $("#txtUsername").setValue("Admin");
        $("#txtPassword").setValue("Ptl@#321");
        $("#btnLogin").click();
        $("#welcome").shouldHave(exactText("Welcome Admin"));
    }

    @Test(groups = {"regression"})
    public void testInvalidUserLoginWithBlankUsernameAndPassword(){
        $("#txtUsername").clear();
        $("#txtPassword").clear();
        $("#btnLogin").click();
        $("#spanMessage").shouldHave(exactText("Username cannot be empty"));
    }

    @Test(groups = {"regression"}, dataProvider = "invalid-user-login-data", dataProviderClass = HRMTestData.class)
    public void testInvalidUserLoginWithDDT(String username, String password, String expected){
        $("#txtUsername").setValue(username);
        $("#txtPassword").setValue(password);
        $("#btnLogin").click();
        $("#spanMessage").shouldHave(exactText(expected));



    }













}
