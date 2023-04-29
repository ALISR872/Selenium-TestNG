package com.eurotech.tests.day18_extentReports;

import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUserNameTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void wrongUserName() {

        loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong Username Test");

        extentLogger.info("Navigate to the url 'http://eurotech.study/login'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click I understand button");
        loginPage.iUnderstandBtn.click();

        extentLogger.info("Enter wrong /invalid username");
        loginPage.usernameInput.sendKeys("euro@gmail.com");


        extentLogger.info("Enter valid password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        String actualMessage = loginPage.warningMessage.getText();
        String expectedMessage = "Invalid Credentials!";
     //   String expectedMessage = "Invalid Credentials";

        extentLogger.info("Verify that user cannot login");
        Assert.assertEquals(actualMessage,expectedMessage,"Verifying the warning message");

        extentLogger.pass("Passed");

    }

    @Test
    public void wrongPassword()  {

        loginPage = new LoginPage();
        //  Task
        //  navigate http://eurotech.study/login
        //  enter valid username but invalid password
        // validate user cannot login

        extentLogger = report.createTest("Wrong Password Test");

        extentLogger.info("Navigate to the url 'http://eurotech.study/login'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click I understand button");
        loginPage.iUnderstandBtn.click();

        extentLogger.info("Enter valid username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter incorrect/ invalid password");
        loginPage.passwordInput.sendKeys("12345!");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        String actualMessage = loginPage.warningMessage.getText();
        String expectedMessage = "Invalid Credentials!";
       // String expectedMessage = "Invalid Credentials";

        extentLogger.info("Verify that user cannot login");
        Assert.assertEquals(actualMessage,expectedMessage,"Verifying the warning message");

        extentLogger.pass("Passed");
    }
}
