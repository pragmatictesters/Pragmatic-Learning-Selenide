package com.pragmatic.selenide;


import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.pragmatic.selenide.utils.Constants.*;

public class LoginTest  extends SelenideTestBase{


    @Test(groups = {"smoke", "regression"})
    public void testValidUserLogin(){
        $("#txtUsername").setValue(ADMIN_USERNAME);
        $("#txtPassword").setValue(ADMIN_PASSWORD);
        $("#btnLogin").click();
        $("#welcome").shouldHave(exactText("Welcome Admin"));
    }


    @Test(groups = { "regression"})
    public void testValidUserLoginWithEnterKey(){
        $("#txtUsername").setValue(ADMIN_USERNAME);
        $("#txtPassword").setValue(ADMIN_PASSWORD).pressEnter();
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
