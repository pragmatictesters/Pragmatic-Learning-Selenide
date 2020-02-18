package com.pragmatic.selenide;


import com.pragmatic.selenide.util.Constants;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Pragmatic Test Labs
 * @Author Janesh Kodikara
 *
 */
public class LoginTest  extends HRMTestBase {


    @Test(groups = {"smoke", "regression"})
    public void testValidUserLogin(){
        $("#txtUsername").setValue(Constants.ADMIN_USERNAME);
        $("#txtPassword").setValue(Constants.ADMIN_PASSWORD);
        $("#btnLogin").click();
        $("#welcome").shouldHave(exactText("Welcome Admin"));
    }

  @Test(groups = {"smoke", "regression"})
    public void testValidUserLoginWithEnterKey(){
        $("#txtUsername").setValue(Constants.ADMIN_USERNAME);
        $("#txtPassword").setValue(Constants.ADMIN_PASSWORD).pressEnter();
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

    @Test(groups = {"regression"}, dataProvider = "invalid-user-login-data-csv", dataProviderClass = HRMTestData.class)
    public void testInvalidUserLoginWithDDTCSV(String username, String password, String expected){
        $("#txtUsername").setValue(username);
        $("#txtPassword").setValue(password);
        $("#btnLogin").click();
        $("#spanMessage").shouldHave(exactText(expected));
    }


















}
