package com.eurotech.tests.day20_DDF;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    // Create an object from ExcelUtil class-it accept two argument
    // Argument 1: location of the excel file ( path)
    // Argument 2: sheet that we want to open ( sheetName)

    @Test
    public void readExcelFile() {
        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest 2.xlsx","Test Data");

        // how many rows in the sheet?
        int rowNumber = testData.rowCount();
        System.out.println("rowNumber = " + rowNumber);
        System.out.println("‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾");

        // how many columns in the sheet?
        int columnNumber = testData.columnCount();
        System.out.println("columnNumber = " + columnNumber);
        System.out.println("‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾");
        
        // get all columns names
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames());
        System.out.println("‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾");

        // get all data in List of String

        List<Map<String,String>> dataList = testData.getDataList();

        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow = " + oneRow);
        }
        System.out.println("‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾");

        // get 3rd row

        System.out.println("3rd row = " + dataList.get(2));
        System.out.println("‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾");

        // get Coskun's title

        System.out.println("dataList.get(6).get(\"Title\") = " + dataList.get(6).get("Title"));
        System.out.println("‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾");

        // get Keti's company

        System.out.println("dataList.get(10).get(\"Company\") = " + dataList.get(10).get("Company"));
        System.out.println("‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾⎺⎻⎼⎽__⎽⎼⎻⎺‾");
        
        // get array

        String [][] dataArray = testData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));
    }
}
