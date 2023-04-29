package com.eurotech.Exercise;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Cari3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testName() {

        driver.navigate().to("https://demo.aspnetawesome.com/");

        List<WebElement> elements = driver.findElements(By.xpath("(//ul[@class='o-mnits'][@tabindex='-1'])[5]/li"));

        System.out.println("elements.size() = " + elements.size());



    }

    @Test
    public void testExer() throws InterruptedException {

        driver.get("https://www.trabzonspor.org.tr/tr");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".button.red.close.mTop10 ")).click();
        Thread.sleep(2000);

        Actions act = new Actions(driver);

        WebElement takimlar = driver.findElement(By.xpath("//a[.='TAKIMLAR']"));

        act.moveToElement(takimlar).click().perform();

        Thread.sleep(2000);

        WebElement hamsik = driver.findElement(By.xpath("//h5[.='Marek Hamšík']"));

        act.moveToElement(hamsik).contextClick().perform();


        Thread.sleep(2000);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
