package com.eurotech.Exercise;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Cari2 {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.trendyol.com/");

        driver.findElement(By.cssSelector(".modal-close")).click();

        driver.findElement(By.xpath("//button[.='Ayarlar']")).click();
        driver.findElement(By.xpath("//button[.='Seçimlerimi Onayla']")).click();

        driver.findElement(By.xpath("//p[text()='Giriş Yap']")).click();

        driver.findElement(By.xpath("//span[.='Üye Ol']")).click();


    }

    @Test
    public void test1() throws InterruptedException {

        driver.findElement(By.cssSelector("#register-email")).sendKeys("aliserd1661@gmail.com");
        driver.findElement(By.cssSelector("#register-password-input")).sendKeys("1234567");
        driver.findElement(By.xpath("(//span[.='Üye Ol'])[2]")).click();

        String expectedText = "Şifreniz en az 1 harf içermelidir.";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Şifreniz en')]")).getText();

        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void test2() {
        driver.findElement(By.cssSelector("#register-email")).sendKeys("aliserd1661@gmail.com");
        driver.findElement(By.cssSelector("#register-password-input")).sendKeys("abcdefg");
        driver.findElement(By.xpath("(//span[.='Üye Ol'])[2]")).click();

        String expectedText = "Şifreniz en az 1 rakam içermelidir.";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Şifreniz en')]")).getText();

        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void test3() {
        driver.findElement(By.cssSelector("#register-email")).sendKeys("aliserd1661@gmail.com");
        driver.findElement(By.cssSelector("#register-password-input")).sendKeys("abc123");
        driver.findElement(By.xpath("(//span[.='Üye Ol'])[2]")).click();

        String expectedText = "Şifreniz 7 ile 64 karakter arasında olmalıdır.";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Şifreniz 7')]")).getText();

        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void test4() {
        driver.findElement(By.cssSelector("#register-email")).sendKeys("aliserd1661gmail.com");
        driver.findElement(By.cssSelector("#register-password-input")).sendKeys("abc1234");
        driver.findElement(By.xpath("(//span[.='Üye Ol'])[2]")).click();

        driver.findElement(By.cssSelector("#register-email")).click();

        String expectedText = "Lütfen geçerli bir email adresi giriniz.";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'geçerli bir email')]")).getText();

        Assert.assertEquals(actualText,expectedText);

    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
