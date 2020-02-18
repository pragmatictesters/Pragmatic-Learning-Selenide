package com.pragmatic.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Pragmatic Test Labs
 * @Author Janesh Kodikara
 *
 */
public class LandingPage {

    private SelenideElement lnkWelcome= $("a#welcome");
    private SelenideElement lnkLogout =$(By.xpath("//a[contains(text(),'Logout')]"));

    public SelenideElement getWelcomeMessage(){
        return lnkWelcome;
    }

    public LoginPage logout(){
        lnkWelcome.click();
        lnkLogout.click();
        return new LoginPage();
    }
}
