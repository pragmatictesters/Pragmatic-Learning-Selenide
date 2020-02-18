package com.pragmatic.selenide.tests;

import com.codeborne.selenide.Condition;
import com.pragmatic.selenide.HRMTestBase;
import com.pragmatic.selenide.pages.LoginPage;
import com.pragmatic.selenide.util.Constants;
import org.testng.annotations.Test;

/**
 * Created by Pragmatic Test Labs
 * @Author Janesh Kodikara
 *
 */
public class LoginTest extends TestBase {

    @Test
    public void testLoginWithBlankUsernameAndBlankPassword(){

        new LoginPage().typeUsername("")
                .typePassword("")
                .clickLoginError()
                .getError()
                .shouldHave(Condition.exactText("Username cannot be empty"));
    }


    @Test
    public void validUserLogin(){
        new LoginPage().typeUsername(Constants.ADMIN_USERNAME)
                .typePassword(Constants.ADMIN_PASSWORD)
                .clickLoginSuccess()
                .getWelcomeMessage()
                .shouldHave(Condition.exactText("Welcome Admin"));

    }




}
