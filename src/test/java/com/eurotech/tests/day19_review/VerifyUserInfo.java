package com.eurotech.tests.day19_review;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.Pages.ProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    //    Task:
    //    Login as a teacher
    //    Verify that login is successful
    //    Click Edit Profile button
    //    Verify that Github name is "eurotech2023"
    //    Click on Go Back button
    //    Verify that users job title is "Test Automation Engineer" where the company is Apple

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProfilePage profilePage;

    @Test
    public void userInfo() {

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        profilePage = new ProfilePage();

        extentLogger = report.createTest("User Info Test");

        extentLogger.info("Navigate to the url 'http://eurotech.study/login'");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click I understand button");
        loginPage.iUnderstandBtn.click();

        extentLogger.info("Enter email ");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        extentLogger.info("Enter password ");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        extentLogger.info("Click login button ");
        loginPage.loginBtn.click();

        extentLogger.info("Verify that user successfully logged in");
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());

        extentLogger.info("Click 'Edit Profile'  ");
        dashboardPage.navigateMenu("Edit Profile");

        String expectedGitHubUsername = "eurotech2023";
        String actualGitHubName = profilePage.gitHubUsername.getAttribute("value");
        extentLogger.info("Verify that GitHub username is " + expectedGitHubUsername);
        Assert.assertEquals(actualGitHubName,expectedGitHubUsername);

        extentLogger.info("Click 'Go Back' button  ");
        profilePage.goBackButton.click();

        String expectedJobTitle = "Test Automation Engineer";
        String actualJobTitle = dashboardPage.AppleJobTitle.getText();
        extentLogger.info("Verify that Job Title is 'Test Automation Engineer'");
        Assert.assertEquals(actualJobTitle,expectedJobTitle);

        extentLogger.pass("Passed");

    }
}
