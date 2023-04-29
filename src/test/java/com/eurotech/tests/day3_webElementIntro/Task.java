package com.eurotech.tests.day3_webElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task {
    public static void main(String[] args) throws InterruptedException {

        // open Chrome browser
        // navigate to "http://eurotech.study/login"
        // enter username and password ""eurotech@gmail.com" / "Test12345!"
        // Verify login succesfully
        // Verify that Dashboard text is exist


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys("Test12345!");
        Thread.sleep(2000);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();
        Thread.sleep(2000);

        WebElement dashboard = driver.findElement(By.id("dashboard-h1"));
        System.out.println("dashboard.getText() = " + dashboard.getText());
        String expectedText = "Dashboard";
        String actualText = dashboard.getText();

        if (expectedText.equals(actualText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }


        driver.close();


    }
}
