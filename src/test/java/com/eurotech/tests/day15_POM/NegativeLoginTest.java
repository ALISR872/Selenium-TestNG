package com.eurotech.tests.day15_POM;


import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPassword() {

        driver.get(ConfigurationReader.get("url"));

        loginPage.iUnderstandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys("wrongPassword");
        loginPage.loginBtn.click();


        Assert.assertTrue(loginPage.warningMessage.isDisplayed(),"verifying warning message is displayed upon invalid login");
        String expectedMessage = "Invalid Credentials!";
        Assert.assertEquals(loginPage.warningMessage.getText(),expectedMessage,"verifying the warning message equal to \"Invalid Credentials\"");

    }
    @Test
    public void wrongUsername() {

    //    LoginPage loginPage = new LoginPage();
        driver.get(ConfigurationReader.get("url"));


        loginPage.iUnderstandBtn.click();
        loginPage.usernameInput.sendKeys("invalidUsername@gmail.com");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtn.click();


        Assert.assertTrue(loginPage.warningMessage.isDisplayed(),"verifying warning message is displayed upon invalid login");
        String expectedMessage = "Invalid Credentials!";
        Assert.assertEquals(loginPage.warningMessage.getText(),expectedMessage,"verifying the warning message equal to \"Invalid Credentials\"");

    }
}
