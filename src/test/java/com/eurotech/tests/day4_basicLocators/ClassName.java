package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassName {
    public static void main(String[] args) throws InterruptedException {
 //       WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
 //        driver.get("http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();

        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Test12345!");
        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(1000);
        String str = driver.findElement(By.className("hide-sm")).getText();
        System.out.println("str = " + str);

        Thread.sleep(4000);
        driver.close();
    }
}
