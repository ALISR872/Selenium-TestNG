package com.eurotech.tests.day2_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        Thread.sleep(3000);

       // driver.close();  --> if run this, trabzonspor page will never open

        driver.get("https://www.trabzonspor.org.tr");

        Thread.sleep(3000);

     //   driver.close(); // close current tab
        driver.quit(); // quit all the chrome browser

    }
}
