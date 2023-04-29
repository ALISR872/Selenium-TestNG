package com.eurotech.tests.day8_typesOfElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableDisableElement {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textBox = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(textBox.isEnabled(),"verify text is disabled");

        WebElement enableDisableButton = driver.findElement(By.xpath("//button[.='Enable']"));
        enableDisableButton.click();

        Thread.sleep(3000);
        Assert.assertTrue(textBox.isEnabled(),"verify text is enabled");


        driver.close();
    }
}
