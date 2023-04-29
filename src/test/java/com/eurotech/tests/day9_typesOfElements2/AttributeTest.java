package com.eurotech.tests.day9_typesOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.cssSelector("#userEmail-wrapper"));
        //ut.println("id: " + fullName.getAttribute("id"));
        //System.out.println("autocomplete: " + fullName.getAttribute("autocomplete"));
        //System.out.println("class: " + fullName.getAttribute("class"));

        System.out.println("outerHTML: "+ fullName.getAttribute("outerHTML"));
        System.out.println("innerHTML: "+ fullName.getAttribute("innerHTML"));

        WebElement fullNameBroad = driver.findElement(By.xpath("//div[@id='userName-wrapper']"));
        System.out.println("outerHTML2: "+ fullNameBroad.getAttribute("outerHTML"));
        System.out.println("innerHTML2: "+ fullNameBroad.getAttribute("innerHTML"));

        //System.out.println("driver.getPageSource() = " + driver.getPageSource());


        Thread.sleep(2000);
        driver.close();
    }
}
