package com.eurotech.tests.day10_typesOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        driver.findElement(By.linkText("Click Here")).click();

 //       Thread.sleep(2000);
 //       String titleAfterClick = driver.getTitle();
 //       System.out.println("titleAfterClick = " + titleAfterClick);

        // get the ID of current page
        String myWindowsID = driver.getWindowHandle(); // get current windows ID ( main page ID)
        System.out.println("window = " + myWindowsID);

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            //handle keeping all windows ID by one by
            if(!handle.equals(myWindowsID)){
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(2000);
        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);
    }

    @Test
    public void multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals("New Window")){
                break;
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
