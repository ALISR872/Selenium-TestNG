package com.eurotech.tests.day2_webDriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.trabzonspor.org.tr");

        Thread.sleep(2000);

        driver.navigate().to("https://www.youtube.com/@trabzonspor");

        Thread.sleep(2000);

        driver.get("https://www.amazon.com.tr/");

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().forward();



        driver.quit();

        driver.close();

    }
}
