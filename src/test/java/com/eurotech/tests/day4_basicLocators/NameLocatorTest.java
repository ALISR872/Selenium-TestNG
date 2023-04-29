package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_in");

        driver.findElement(By.id("accept-cookie-notification")).click();

        Faker faker = new Faker();

        WebElement eMailInput = driver.findElement(By.name("user[login]"));
        eMailInput.sendKeys(faker.internet().emailAddress());

        WebElement passwordInput = driver.findElement(By.name("user[password]"));
        passwordInput.sendKeys(faker.internet().password());




        Thread.sleep(4000);
        driver.close();
    }
}
