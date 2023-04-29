package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.tagName("h2")).getText());

        Thread.sleep(4000);
        driver.close();
    }
}
