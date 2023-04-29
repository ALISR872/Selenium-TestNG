package com.eurotech.tests.day9_typesOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> listItems = driver.findElements(By.xpath("//a[.='A/B Testing']/../../li"));
        //  List<WebElement> listItems = driver.findElements(By.xpath("//li")); --> this is also possible, but initial stronger as U have reference

        int expectedSize = 44;
        int actualSize = listItems.size();

        Assert.assertEquals(actualSize, expectedSize, "verifying there are " + expectedSize + " items");


        for (WebElement listItem : listItems) {
            System.out.println(listItem.getText());
        }

        //////// Iterate over list items and click the “checkboxes" /////

        String itemToClick = "Checkboxes";
        for (WebElement item : listItems) {
            //   System.out.println("item.getText() = " + item.getText());
            if (itemToClick.equals(item.getText())) {
                System.out.println("Item to click " + itemToClick + " found, will click");
                item.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    @Test
    public void test2() {

        driver.get("https://demoqa.com/elements");
        List<WebElement> listElements = driver.findElements(By.xpath("//span[text()='Text Box']/../../li/span"));

        int expectedSize = 9;
        int actualSize = listElements.size();

        Assert.assertEquals(actualSize, expectedSize, "verifying there are " + expectedSize + " items");

        for (WebElement elementsItem : listElements) {
            System.out.println(elementsItem.getText());
            Assert.assertTrue(elementsItem.isDisplayed());
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
