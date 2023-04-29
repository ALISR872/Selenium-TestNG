package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartialLinkTextTest {
    public static void main(String[] args) throws InterruptedException {


        // navigate to dynamic loading
        // click Example 2
        // verify that text is "Example 2: Element rendered after the fact"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement example2 = driver.findElement(By.partialLinkText("Example 2"));
        example2.click();

        WebElement h4 = driver.findElement(By.tagName("h4"));
        String expectedText = "Example 2: Element rendered after the fact";

        String actualText = h4.getText();

        if (expectedText.equals(actualText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        Thread.sleep(2000);

        driver.close();

    }
}
