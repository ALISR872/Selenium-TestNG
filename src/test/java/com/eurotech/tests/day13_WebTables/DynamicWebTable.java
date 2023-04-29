package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicWebTable {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void dynamicNegative() {

        driver.get("https://demoqa.com/webtables");
        WebElement kierra = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[3]/div/div[1]"));
        System.out.println("cierra.getText() = " + kierra.getText());

        driver.findElement(By.xpath("//*[.='Last Name']")).click();

        System.out.println("After click: " + kierra.getText());

    }
    @Test
    public void dynamicPositive() {

        driver.get("https://demoqa.com/webtables");
        WebElement kierra = driver.findElement(By.xpath("//*[.='Kierra']"));

        System.out.println("Before click = " + kierra.getText());

        driver.findElement(By.xpath("//*[.='Last Name']")).click();

        kierra = driver.findElement(By.xpath("//*[.='Kierra']"));

        System.out.println("After click: " + kierra.getText());

        Assert.assertEquals(kierra.getText(),"Kierra");
    }

    @Test
    public void dynamic2() {
        driver.get("file:///Users/Ay%C5%9Fenur/Desktop/WebTable.html");
       // WebElement marycountry = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
        WebElement marycountry = driver.findElement(By.xpath("//td[.='Mary']/../td[3]"));
        System.out.println("Before Click: " + marycountry.getText());

        driver.findElement(By.xpath("//th[.='Email']")).click();

        //marycountry = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
        marycountry = driver.findElement(By.xpath("//td[.='Mary']/../td[3]"));
        System.out.println("After Click: " + marycountry.getText());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
