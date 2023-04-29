package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverTest{



  /*  @Test
    public void test1() throws InterruptedException {
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));

        Thread.sleep(2000);
        Driver.closeDriver();
    } */

    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
       // WebDriver driver = Driver.get();
        driver.get("https://amazon.com/");
        Thread.sleep(2000);

       // driver.close();

       // Driver.closeDriver();

    }

    @Test
    public void test3() {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
       // WebDriver driver = Driver.get();
        driver.get("https://google.com/");

       // driver.close();

       // Driver.closeDriver();

    }
}
