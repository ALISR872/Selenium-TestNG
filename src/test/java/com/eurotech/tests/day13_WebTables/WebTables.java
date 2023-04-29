package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");

        WebElement demoTable = driver.findElement(By.xpath("//h3[.='Demo Table 2']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",demoTable);
    }

    @Test
    public void printTable() {
    //  print table Demo Table 2

        WebElement table1 = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println(table1.getText());
    }

    @Test
    public void getAllHeader() {

        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead//th"));
        WebElement element = driver.findElement(By.xpath("//table[@border='1']/thead"));

        System.out.println(element.getText());
        System.out.println("allHeader.size() = " + allHeaders.size());

        for (WebElement header : allHeaders) {
            System.out.println(header.getText());
        }

        System.out.println("********************");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));

        for (WebElement row : rows) {
            System.out.println("row = " + row.getText());
        }

    }

    @Test
    public void getRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));

        // get second row which is starting clock tower hotel
        WebElement secondRow = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println("secondRow.getText() = " + secondRow.getText());

        for (int i = 1; i <= rows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+i+"]"));
            System.out.println("row.getText() = " + row.getText());
        }
    }

    @Test
    public void getAllCellInOneRow() {
        List<WebElement> financial = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[4]/td"));
        System.out.println("financial.size() = " + financial.size());

        for (WebElement webElement : financial) {
            System.out.println(webElement.getText());
        }

    }

    @Test
    public void getOneCell() {
        WebElement mekke = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[2]"));

        System.out.println("mekke = " + mekke.getText());
    }

    @Test
    public void printAllCellByIndex() {
        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfCol();

        System.out.println("rowNumber = " + rowNumber);
        System.out.println("colNumber = " + colNumber);

        //iterate each row on the table

        for (int i = 1; i <= rowNumber ; i++) {
            // iterate each cell in the row
            for (int j = 1; j < colNumber ; j++) {
                String cellXpath = "//table[@border='1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());
            }

        }


    }

    private int getNumberOfCol() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        return columns.size();
    }

    private int getNumberOfRows() {

        List<WebElement>rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
