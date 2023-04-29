package com.eurotech.tests.day15_POM;

import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Override

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void login() throws InterruptedException {

        loginPage.iUnderstandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtn.click();


        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard", "verifiying that user successfully ");
    }

    @Test
    public void loginWithMethod() throws InterruptedException {

        String username = ConfigurationReader.get("usernameTeacher");
        String password = ConfigurationReader.get("passwordTeacher");

        loginPage.login(username, password);

        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test
    public void loginWithLoginAsTeacher() throws InterruptedException {

        loginPage.loginAsTeacher();

        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test
    public void loginWithLoginAsStudent() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));

        loginPage.loginAsStudent();

        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }
}
