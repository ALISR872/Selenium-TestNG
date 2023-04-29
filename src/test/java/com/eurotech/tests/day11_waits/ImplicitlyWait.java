package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        System.out.println("driver.findElement(By.cssSelector(\"#message\")).getText() = "
                + driver.findElement(By.cssSelector("#message")).getText());

    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();


        String actualText = driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
        String expectedText = "Hello World!";

        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void testName() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();

        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);// 15 is maxTime, it will work findElement() method

        WebElement message = driver.findElement(By.cssSelector("#message"));

        Assert.assertEquals(message.getText(), "It's gone!");

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
