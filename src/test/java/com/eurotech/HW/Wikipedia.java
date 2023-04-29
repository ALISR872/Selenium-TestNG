package com.eurotech.HW;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wikipedia {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        WebElement selectLanguage = driver.findElement(By.xpath("//option[@value='en']"));
        selectLanguage.click();

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
        searchBox.sendKeys("selenium web driver");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        WebElement seleniumSoftware = driver.findElement(By.xpath(
                "//a[@title='Selenium (software)']"));
        seleniumSoftware.click();

        String title = driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();

        if(title.contains("Selenium")){
            System.out.println("Title test: Passed");
        }else{
            System.out.println("Title test: Failed");
        }

        String currentURL = driver.getCurrentUrl();

        if(currentURL.endsWith("Selenium_(software)")){
            System.out.println("URL test : Passed");
        }else{
            System.out.println("URL test : Failed");
        }

        Thread.sleep(4000);
        driver.close();
    }
}
