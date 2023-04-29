package com.eurotech.tests.day6_cssSelector;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssSelectorTEst {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");
        driver.manage().window().maximize();

       // Thread.sleep(4000);
        driver.findElement(By.cssSelector(
                "[class='popup']>div>div>div>button")).click(); // [class='popup']>div button


        WebElement eMail = driver.findElement(By.cssSelector("#loginpage-input-email"));
        eMail.sendKeys("eurotech@gmail.com");



        WebElement password = driver.findElement(By.cssSelector("[placeholder='Password']"));
        password.sendKeys("Test12345!");


        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();

        Thread.sleep(3000);
        driver.close();
    }
}
