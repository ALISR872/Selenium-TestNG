package com.eurotech.tests.day2_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetTitleAndGetURL {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String actualTitle = driver.getTitle();
        System.out.println("driver.getTitle() = " + driver.getTitle());

        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getPageSource() = " + driver.getPageSource());

        driver.close();
    }
}
