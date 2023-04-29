package com.eurotech.tests.day3_webElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLChanged {
    public static void main(String[] args) throws InterruptedException {
        // open the chrome browser
        // enter email address as "eurotech@gmail.com"
        // enter password as "Test12345!"
        // click login button
        // verify that URL has changed



        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");
        Thread.sleep(3000);
        WebElement understndBtn = driver.findElement(By.id("rcc-confirm-button"));
        understndBtn.click();

        String email = "eurotech@gmail.com";
        String password = "Test12345!";

        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys(email);
        Thread.sleep(3000);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        Thread.sleep(3000);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        Thread.sleep(3000);
        String expectedURL = "http://eurotech.study/dashboard";

        Thread.sleep(3000);

        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }


        driver.close();



    }
}
