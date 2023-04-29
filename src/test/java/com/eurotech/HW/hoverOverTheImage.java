package com.eurotech.HW;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class hoverOverTheImage {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @Test
    public void imgTexts_isDisplayed() {
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(img1).perform();

        WebElement img1Text = driver.findElement(By.xpath("//h5[.='name: user1']"));

        String expectedTextImg1 = "name: user1";
        String actualTextImg1 = img1Text.getText();
        Assert.assertEquals(actualTextImg1, expectedTextImg1);
        Assert.assertTrue(img1Text.isDisplayed(), "verify that the text \"name: user1\" appears");


        WebElement img2 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
        actions.moveToElement(img2).perform();

        WebElement img2Text = driver.findElement(By.xpath("//h5[.='name: user2']"));
        String expectedTextImg2 = "name: user2";
        String actualTextImg2 = img2Text.getText();
        Assert.assertEquals(actualTextImg2, expectedTextImg2);
        Assert.assertTrue(img2Text.isDisplayed(), "verify that the text \"name: user2\" appears");


        WebElement img3 = driver.findElement(By.xpath("(//img)[4]"));
        actions.moveToElement(img3).perform();

        WebElement img3Text = driver.findElement(By.xpath("//h5[.='name: user3']"));
        String expectedTextImg3 = "name: user3";
        String actualTextImg3 = img3Text.getText();
        Assert.assertEquals(actualTextImg3, expectedTextImg3);
        Assert.assertTrue(img3Text.isDisplayed(), "verify that the text \"name: user3\" appears");

    }

    @Test
    public void hover() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");


        for (int i = 2; i <= 4; i++) {

            String xpathImg = "(//img)[" + i + "]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textPath = "//h5[text()='name: user" + (i - 1) + "']";
            WebElement text = driver.findElement(By.xpath(textPath));
            System.out.println(textPath);

            Assert.assertTrue(text.isDisplayed(), "verify user" + (i - 1) + " is displayed");

        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
