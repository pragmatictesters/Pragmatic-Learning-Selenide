package com.pragmatic.selenide;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Pragmatic Test Labs
 * @Author Janesh Kodikara
 *
 */
public class AddEmployeeTest extends HRMTestBase {


    @Test
    public void testAddEmployeesWithMandatoryDetails() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        login();
        navigateToAddEmployeePage();
        $("input#firstName").setValue(firstName);
        $("input#lastName").setValue(lastName);
        $("input#btnSave").click();

        $("input#personal_txtEmpFirstName").shouldHave(exactValue(firstName));
        $("input#personal_txtEmpLastName").shouldHave(exactValue(lastName));

    }


    @Test
    public void testAddEmployeesWithoutMandatoryDetails() {

        login();
        navigateToAddEmployeePage();
        $("input#firstName").clear();
        $("input#lastName").clear();
        $("input#btnSave").click();
        $("input#firstName").shouldHave(cssClass("validation-error"));
        $("input#middleName").shouldNotHave(cssClass("validation-error"));
        $("input#lastName").shouldHave(cssClass("validation-error"));
        $("span[for='firstName']").shouldBe(appear).shouldHave(exactText("Required"));
        $("span[for='lastName']").shouldBe(appear).shouldHave(exactText("Required"));

        Selenide.refresh();
        $("input#firstName").shouldNotHave(cssClass("validation-error"));
        $("input#lastName").shouldNotHave(cssClass("validation-error"));
        $("span[for='firstName']").shouldNot(appear);
        $("span[for='lastName']").shouldNot(appear);
    }



    @Test
    public void testAddEmployeesWithProfilePicture() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String profilePicture = "src/test/resources/pics/janesh_kodikara_present.png";


        login();
        navigateToAddEmployeePage();
        $("input#firstName").setValue(firstName);
        $("input#lastName").setValue(lastName);
        $("input#photofile").uploadFile(new File(profilePicture));

        $("input#btnSave").click();
        //TODO : Add assertion for image verification
        $("input#personal_txtEmpFirstName").shouldHave(exactValue(firstName));
        $("input#personal_txtEmpLastName").shouldHave(exactValue(lastName));
    }


    @Test
    public void testAddEmployeesWithLoginInformation() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = faker.name().username();
        String password = "Ptl@#321";
        String profilePicture = "src/test/resources/pics/janesh_kodikara_present.png";


        login();
        navigateToAddEmployeePage();
        $("input#firstName").setValue(firstName);
        $("input#lastName").setValue(lastName);
        $("input#photofile").uploadFile(new File(profilePicture));
        $("input#chkLogin").setSelected(true).shouldBe(selected);
        $("input#user_name").setValue(username);
        $("input#user_password").setValue(password);
        $("input#re_password").setValue(password);

        $("input#btnSave").click();
        //TODO : Add assertion for image verification
        $("input#personal_txtEmpFirstName").shouldHave(exactValue(firstName));
        $("input#personal_txtEmpLastName").shouldHave(exactValue(lastName));

        logout();
        login(username,password);
        $("#welcome").shouldHave(exactText("Welcome " + firstName));
    }


    @Test(dataProvider = "new-employee-mandatory-information", dataProviderClass = HRMTestData.class)
    public void testAddEmployeesWithMandatoryDetailsDDT(String firstName, String lastName) {
        login();
        navigateToAddEmployeePage();
        $("input#firstName").setValue(firstName);
        $("input#lastName").setValue(lastName);
        $("input#btnSave").click();

        $("input#personal_txtEmpFirstName").shouldHave(exactValue(firstName));
        $("input#personal_txtEmpLastName").shouldHave(exactValue(lastName));
    }


    private void navigateToAddEmployeePage() {
        $("a#menu_pim_viewPimModule").click();
        $("a#menu_pim_addEmployee").click();
    }
}
