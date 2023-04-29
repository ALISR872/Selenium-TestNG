package com.eurotech.tests.day9_typesOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTEst {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));
        Select select = new Select(colorDropdown);
        // verify there are 11 colors in this dropdown
        // print all the colors
        List<WebElement> colorOptions = select.getOptions();


        int expectedNumOfColor = 11;
        int actualNumOfColor = colorOptions.size();

        Assert.assertEquals(actualNumOfColor,expectedNumOfColor,
                "verifying there are "+ expectedNumOfColor+" colors");

        for (WebElement color:colorOptions) {
            System.out.println("color.getText() = " + color.getText());
        }

        // verify the initial color/default color is Red
        String expectedColor = "Red";
        String actualColor = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor,expectedColor,"verifying default color is Red");

        // -1- select yellow by visibleTest and verify it has been selected

        select.selectByVisibleText("Yellow");

        Assert.assertTrue("Yellow".equals(select.getFirstSelectedOption().getText()),"verify...");

        // -2- select Green by index and verify it has been selected

        select.selectByIndex(2);
        Thread.sleep(1000);
        Assert.assertTrue("Green".equals(select.getFirstSelectedOption().getText()),"verify...");

        // -3- select Indigo by value and verify it has been selected

        select.selectByValue("8");
        Thread.sleep(1000);
        Assert.assertTrue("Indigo".equals(select.getFirstSelectedOption().getText()),"verify...");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
