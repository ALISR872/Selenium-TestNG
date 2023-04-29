package com.eurotech.tests.day3_webElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLNotChanged {
    public static void main(String[] args) throws InterruptedException {

        // open chrome browser
        // go to https://eurotech.study/login
        // click login button
        // verify that URL not changed

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");

        Thread.sleep(3000);

        WebElement undrstndBtn = driver.findElement(By.id("rcc-confirm-button"));
        undrstndBtn.click();

        String expectedURL = driver.getCurrentUrl();
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));

        loginBtn.click();

        Thread.sleep(3000);

     //   String expectedURL = "http://eurotech.study/login";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }


   // driver.close();


    }
}
