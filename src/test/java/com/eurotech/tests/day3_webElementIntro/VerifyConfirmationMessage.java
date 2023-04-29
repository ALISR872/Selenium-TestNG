package com.eurotech.tests.day3_webElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        // open chrome browser
        // go to "http://eurotech.study/login"
        // enter valid credentials ""eurotech@gmail.com" / "Test12345!"
        // verify that confirmation message is "Welcome Teacher"

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");

        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(3000);


        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys("eurotech@gmail.com");

        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("Test12345!");

        Thread.sleep(2000);

        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(2000);

        WebElement welcomeMessage = driver.findElement(By.id("dashboard-p1"));
        // we have 2 ways to get text from web pages
        // first getText() -->  it will work %99 and it will return String
        // second getAttribute()
        //first
        System.out.println(welcomeMessage.getText());

        String expectedText = "Welcome Teacher";
        String actualText = welcomeMessage.getText();

        if (expectedText.equals(actualText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }



        driver.close();


    }
}
