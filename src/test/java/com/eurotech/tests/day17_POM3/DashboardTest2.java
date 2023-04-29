package com.eurotech.tests.day17_POM3;

import com.eurotech.Pages.BasePage;
import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.Pages.PostsPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    PostsPage postsPage = new PostsPage();

    @Test
    public void navigateList() throws InterruptedException {

      /*  Go to http://www.eurotech.study/
        Login with teacher credentials
        Verify log in successfully
        verify following menu's url
        Edit Profile
        Add Experience
        Add Education */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        Thread.sleep(1000);
        String expectedURL = "http://eurotech.study/dashboard";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        dashboardPage.navigateMenu("Edit Profile");
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/edit-profile");

        driver.navigate().back();

        dashboardPage.navigateMenu("Add Experience");
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/add-experience");

        driver.navigate().back();

        dashboardPage.navigateMenu("Add Education");
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/add-education");

    }


    @Test
    public void verifyList() throws InterruptedException {
        /*  Go to http://www.eurotech.study/
        Login with teacher credentials
        Verify log in successfully
        verify following menu
        Edit Profile
        Add Experience
        Add Education */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        Thread.sleep(1000);


        String actualText = dashboardPage.welcomeMessage.getText();
        String expectedText = "Welcome Teacher";

        Assert.assertEquals(actualText, expectedText, "Verify that login in successfully");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Edit Profile");
        expectedList.add("Add Experience");
        expectedList.add("Add Education");

        List<String> actualList = new ArrayList<>();
        for (WebElement list : dashboardPage.dashboardList) {
            actualList.add(list.getText());
        }

        Assert.assertEquals(actualList, expectedList);

        // 2 way

        List<WebElement> dashboardList = dashboardPage.dashboardList;
        for (WebElement element : dashboardList) {
            actualList.add(element.getText());
        }

        // 3 way

        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.dashboardList), expectedList);

    }

    @Test
    public void logout() throws InterruptedException {
        /**
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Account and navigate to My Posts and verify that submit button is true and visible then
         Navigate to Log Out and verify that log out successfully
         */


        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String actualText = dashboardPage.welcomeMessage.getText();
        String expectedText = "Welcome Teacher";

        Assert.assertTrue(actualText.contains(expectedText));

        // 1 way navigate to My Account

        //  dashboardPage.navigateMenu("My Account");

        // 2 way navigate to My Account
        BrowserUtils.hover(dashboardPage.myAccount);

        dashboardPage.navigateSubMenu("My Posts");

        // 1 way
        BrowserUtils.verifyElementDisplayed(postsPage.submitBtn);

        // 2 way

        BrowserUtils.waitForVisibility(postsPage.submitBtn, 10);
        Assert.assertTrue(postsPage.submitBtn.isDisplayed());

        String expectedTextSubmitBtn = "Submit";
        String actualTextSubmitBtn = postsPage.submitBtn.getAttribute("value");

        Assert.assertEquals(actualTextSubmitBtn, expectedTextSubmitBtn);

        Assert.assertEquals(postsPage.submitBtn.getAttribute("value"), "Submit");

        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("Logout");

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

    }

    @Test
    public void postComment() throws InterruptedException {
        /**
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Account and navigate to My Posts
         Fill the title and post area
         Click submit button
         Verify that post saved successfully
        */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        String actualText = dashboardPage.welcomeMessage.getText();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(actualText, expectedText, "Verify that login in successfully");

        BrowserUtils.hover(dashboardPage.myAccount);

        dashboardPage.navigateSubMenu("My Posts");

        String expectedURL = "http://eurotech.study/posts";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

        // 1 way

  //      postsPage.titleInput.sendKeys("Page Object Model");
  //      postsPage.postInput.sendKeys("TS");
  //      postsPage.submitBtn.click();

        // 2 way
        postsPage.postComment("POM","Selenium");
        Assert.assertEquals(postsPage.postCreatedMessage.getText(),"Post Created");

    }
}
