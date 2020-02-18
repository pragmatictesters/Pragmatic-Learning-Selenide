package com.pragmatic.selenide;

import org.testng.annotations.DataProvider;

// PTL
public class HRMTestData {


    @DataProvider(name = "invalid-user-login-data")
    public static Object[][] loginData(){
        return new Object[][] {
                {"", "", "Username cannot be empty"},
                {"", "Ptl@#321", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"Admin", "ptl@#321", "Invalid credentials"},
                {"Admin", "pTL@#321", "Invalid credentials"},
                {"Admin", "PTL@#321", "Invalid credentials"}
        };

    }
}
