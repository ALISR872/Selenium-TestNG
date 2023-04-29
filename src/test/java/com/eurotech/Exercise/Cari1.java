package com.eurotech.Exercise;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cari1 {

    WebDriver driver;
    JavascriptExecutor executor;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        executor = (JavascriptExecutor) driver;
    }


    @Test
    public void test4() throws InterruptedException {
        driver.get("https://www.trendyol.com/");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[.='Ayarlar']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Seçimlerimi Onayla']")).click();
        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();
        alert.dismiss();


        driver.findElement(By.cssSelector(".modal-close")).click();
        Thread.sleep(2000);

    }

    @Test
    public void test6() {
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Trabzon"+Keys.ENTER);
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Ötüken"+Keys.ENTER);
    }

    @Test
    public void test5() throws InterruptedException {
        driver.navigate().to("https://www.hepsiburada.com/");

        driver.findElement(By.xpath("//button[.='Çerez Ayarları']"));
        driver.findElement(By.xpath("//button[contains(.,'Çerez ayar')]")).click();

        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();


    }

    @Test
    public void testName() {
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

       // WebElement element = driver.findElement(By.cssSelector("#dropdown-class-example"));

        //element.click();

        List<WebElement>listDropdown = driver.findElements(By.xpath("//select[@id='dropdown-class-example']/option"));

        for (WebElement webElement : listDropdown) {
            System.out.println(webElement.getText());
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.close();
    }
}
