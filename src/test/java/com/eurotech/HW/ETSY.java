package com.eurotech.HW;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ETSY {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement searchBox= driver.findElement(By.xpath(
                "//input[@data-id='search-query']"));

        searchBox.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath(
                "//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']/.."));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath(
                "//span[contains(text(),'results')]"));

        String searchText= searchResult.getText();


        int l = searchText.length();

        String numberOfResult = searchText.substring(0,l-9);

        System.out.println("number of Selenium result = " + numberOfResult);

    }
}
