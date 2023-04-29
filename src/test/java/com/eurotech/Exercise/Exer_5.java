package com.eurotech.Exercise;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exer_5 {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement check2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        Assert.assertTrue(check2.isSelected(),"checkbox2 is not selected");

    }
}
