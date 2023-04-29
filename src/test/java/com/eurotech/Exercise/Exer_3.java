package com.eurotech.Exercise;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Exer_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com");

       // *** driver.findElement(By.xpath("//a[text()='Explore now']")).click();
       // driver.findElement(By.xpath("//a[text()='Explore now']/..")).click();
       // driver.findElement(By.xpath("//a[text()='Explore now']/../..")).click();

       // *** driver.findElement(By.xpath("//h2[.='Get fit at home']/../..")).click();
        driver.findElement(By.xpath("//h2[contains(.,'Get fit')]/../..")).click();

        Thread.sleep(3000);
        driver. close();
    }
}
