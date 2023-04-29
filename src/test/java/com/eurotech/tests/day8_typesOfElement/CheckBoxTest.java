package com.eurotech.tests.day8_typesOfElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest {

    @Test
    public void testName() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox2 is selected by default");
        Assert.assertFalse(checkbox1.isSelected(),"verify checkbox1 is not selected by default");
        Thread.sleep(1000);
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected(),"verify checkbox1 is selected after clicking");

        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected(),"verify checkbox2 is not selected after clicking");

        Thread.sleep(2000);
        driver.close();
    }
}
