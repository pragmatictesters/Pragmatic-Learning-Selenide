package com.pragmatic.selenide.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Pragmatic Test Labs
 * @Author Janesh Kodikara
 *
 */
public class HRMTestData {

    @DataProvider(name = "invalid-user-login-data")
    public static Object[][] userLoginData() {
        return new Object[][]{
                {"", "", "Username cannot be empty"},
                {"", "Ptl@#321", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
                {"Admin", "ptl@#321", "Invalid credentials"},
                {"Admin", "pTL@#321", "Invalid credentials"},
                {"Admin", "PTL@#321", "Invalid credentials"},
                {"Admin", "test", "Invalid credentials"}
        };
    }

    @DataProvider(name = "invalid-user-login-data-csv")
    public static Object[][] userLoginDataCSV() {

        String csvFile = "src/test/resources/invalid-user-login-data.csv";
        Object[][] data = getObjects(csvFile);
        if (data != null) return data;

        return null;
    }

    @DataProvider(name="new-employee-mandatory-information")
    public static Object[][] newEmployeeMandatoryData(){
        String csvFile = "src/test/resources/new-employees-mandatory-details.csv";
        Object[][] data = getObjects(csvFile);
        if (data != null) return data;

        return null;

    }



    public static Object[][] getObjects(String csvFile) {
        try {

            CSVReader reader;
            Object[][] data = null;

            int dataRow = 0;

            reader = new CSVReader(new FileReader(csvFile));
            int rows= reader.readAll().size()-1;
            reader.close();

            reader = new CSVReader(new FileReader(csvFile));
            int columns = reader.readNext().length;
            data = new Object[rows][columns];

            String[] line;
            while ((line = reader.readNext()) != null) {
                for (int i = 0; i < columns; i++) {
                    data[dataRow][i] = line[i];
                }
                dataRow++;
            }
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
