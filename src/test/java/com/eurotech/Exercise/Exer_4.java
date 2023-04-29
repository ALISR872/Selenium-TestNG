package com.eurotech.Exercise;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exer_4 {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");


        WebElement vegetablesButton = driver.findElement(By.xpath(
                "//div[.='Vegetables']/../input"));

        Assert.assertTrue(vegetablesButton.isSelected(),
                "Verifying 'vegetables' radio button is selected");

        Thread.sleep(1000);

        WebElement fruitsButton = driver.findElement(By.xpath("//div[.='Fruits']/../input"));

        Assert.assertFalse(fruitsButton.isSelected(),"Verifying 'fruits' radio button isn't selected");

        WebElement selectFruits = driver.findElement(By.xpath("//div[.='Fruits']/../div"));
        selectFruits.click();

        Assert.assertTrue(fruitsButton.isSelected(),"Verifying 'fruits' radio button is selected");
        Assert.assertFalse(vegetablesButton.isSelected(),
                "Verifying 'vegetables' radio button isn't selected");



        Thread.sleep(3000);
        driver.close();


    }
}
