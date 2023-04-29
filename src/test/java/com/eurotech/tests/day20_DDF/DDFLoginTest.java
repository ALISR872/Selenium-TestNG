package com.eurotech.tests.day20_DDF;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @DataProvider
    public Object[][] userData() {
        ExcelUtil testData = new ExcelUtil("src/test/resources2/EurotechTest 2.xlsx", "Test Data");
        return testData.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username, String password, String title, String company, String name) {
        // initialize page objects
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        // name the test case to be shown in report
        extentLogger = report.createTest(name + "'s Login Test ");

        extentLogger.info("Navigating to the url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        // Login Page

        extentLogger.info("Click I understand button");
        loginPage.iUnderstandBtn.click();

        extentLogger.info("Enter username");
        loginPage.usernameInput.sendKeys(username);

        extentLogger.info("Enter password");
        loginPage.passwordInput.sendKeys(password);

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        // Dashboard Page

        extentLogger.info("Verify that title is = " + title);
        Assert.assertEquals(dashboardPage.getCurrentExperienceTitle(title),title);
      //  Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());

        extentLogger.pass("Passed");


        // task
        // validate company value is as given in the Excel
    }
}
