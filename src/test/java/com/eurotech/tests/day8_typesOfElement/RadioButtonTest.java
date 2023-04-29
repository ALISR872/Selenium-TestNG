package com.eurotech.tests.day8_typesOfElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        // verify that vegetables radio button is selected by default
        Thread.sleep(2000);

        WebElement vegetablesRadio1 = driver.findElement(By.xpath(
                "//div[.='Vegetables']//preceding-sibling::*[1]"));

        Assert.assertTrue(vegetablesRadio1.isSelected(),
                "Verifying 'vegetables' radio button is selected");

        // verify that legumes radio button is not selected
        // click "legumes"
        // verify legumes is selected
        // verify vegetables is Not selected

        WebElement legumesRadio = driver.findElement(By.xpath(
                "//div[.='Legumes']/preceding-sibling::*[1]"));

        Assert.assertFalse(legumesRadio.isSelected(),
                "Verifying 'legumes' radio button is not selected");

        driver.findElement(By.xpath("//div[text()='Legumes']/../div[1]")).click();

        Assert.assertTrue(legumesRadio.isSelected(),
                "Verifying 'legumes' radio button is selected");

        WebElement vegetablesRadio2 = driver.findElement(By.xpath(
                "//div[.='Vegetables']/../input"));

        Assert.assertFalse(vegetablesRadio2.isSelected(),
                "Verifying 'vegetables' radio button is not selected");


        driver.close();

    }
}
