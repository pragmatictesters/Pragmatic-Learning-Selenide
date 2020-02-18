package com.pragmatic.selenide;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

// PTL
public class AddEmployeeTest extends HRMTestBase {


    @Test
    public void testAddEmployeesWithMandatoryDetails(){
        login();
        navigateToAddEmployeePage();
        $("input#firstName").setValue("Janesh");
        $("input#lastName").setValue("Kodikara");
        $("input#btnSave").click();
        Selenide.sleep(2000);

    }

    private void navigateToAddEmployeePage() {
        $("a#menu_pim_viewPimModule" ).click();
        $("a#menu_pim_addEmployee" ).click();


    }
}
