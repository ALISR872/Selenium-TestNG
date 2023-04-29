package com.eurotech.tests.day10_typesOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");


        //////////// first way switching iframe
        driver.switchTo().frame("mce_0_ifr"); // id
        Thread.sleep(2000);
        WebElement textArea= driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();
        textArea.sendKeys("Batch6");

        //////////// second way switching iframe

        driver.switchTo().parentFrame(); // if we use index or tagname

        driver.switchTo().frame(0);
        Thread.sleep(2000);

        textArea.clear();
        textArea.sendKeys("EuroTech");

        // third way
   //     driver.switchTo().parentFrame();    // if we use index or tagname
     //   WebElement iframe = driver.findElement(By.tagName("iframe"));
   //     driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        textArea.clear();
        textArea.sendKeys("Hello");

    }

    @Test
    public void nestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // get text middle

        // default content
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String textMiddle = driver.findElement(By.cssSelector("#content")).getText();
        System.out.println("textMiddle = " + textMiddle);


        //driver.switchTo().parentFrame(); //-->bir üste gider
        driver.switchTo().defaultContent(); // it will go to top --> en üste gider
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right"); // or driver.switchTo().frame(2);
        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println("body.getText() = " + body.getText());


        driver.switchTo().defaultContent(); // it will go to top
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }

    @Test
    public void testName() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String textMiddle = driver.findElement(By.cssSelector("#content")).getText();
        System.out.println("textMiddle = " + textMiddle);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}