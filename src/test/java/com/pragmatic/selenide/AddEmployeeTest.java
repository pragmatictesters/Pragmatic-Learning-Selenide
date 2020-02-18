package com.pragmatic.selenide;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;

// PTL
public class AddEmployeeTest extends HRMTestBase {


    @Test
    public void testAddEmployeesWithMandatoryDetails(){

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        login();
        navigateToAddEmployeePage();
        $("input#firstName").setValue(firstName);
        $("input#lastName").setValue(lastName);
        $("input#btnSave").click();
        Selenide.sleep(2000);

        $("input#personal_txtEmpFirstName").shouldHave(exactValue(firstName));
        $("input#personal_txtEmpLastName").shouldHave(exactValue(lastName));
    }

    private void navigateToAddEmployeePage() {
        $("a#menu_pim_viewPimModule" ).click();
        $("a#menu_pim_addEmployee" ).click();
    }
}
