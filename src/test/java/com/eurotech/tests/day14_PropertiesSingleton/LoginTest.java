package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {


    @Test
    public void testName() {
        driver.get(ConfigurationReader.get("url"));


        WebElement ıUnderstandBtn = driver.findElement(By.id("rcc-confirm-button"));
        WebElement usernameInput = driver.findElement(By.name("email"));
        WebElement passwordInput= driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));

        ıUnderstandBtn.click();
        usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("userPassword"));
        loginBtn.click();

    }


}
