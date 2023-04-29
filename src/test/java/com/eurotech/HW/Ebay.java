package com.eurotech.HW;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ebay {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath(
                "//input[@class='btn btn-prim gh-spr']"));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath(
                "//h1[contains(text(),'results for')]"));

        String searchText = searchResult.getText();

        if( searchText.contains("selenium")){
            System.out.println("Selenium test : Passed");
        }else{
            System.out.println("Selenium test : Failed");
        }
    }
}
