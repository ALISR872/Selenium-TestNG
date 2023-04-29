package com.eurotech.Exercise;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Exer_2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        Faker faker = new Faker();

        /*  ///////// id ///////////

        driver.get("https://demoqa.com/elements");

        Thread.sleep(3000);



        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
        element1.click();

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys(faker.name().fullName());

        String x = fullName.getAttribute("value");
        System.out.println(x);

        WebElement eMail =driver.findElement(By.id("userEmail"));
        eMail.sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("permanentAddress")).sendKeys(faker.address().fullAddress());

        Thread.sleep(3000);

        driver.findElement(By.id("submit")).click();

        /////////////////////// name - tagname /////////////

        driver.get("https://www.browserstack.com/");

        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[5]/a"));
        System.out.println("signIn.getText() = " + signIn.getText());
        signIn.click();

        WebElement eMail = driver.findElement(By.name("user[login]"));
        eMail.sendKeys(faker.internet().emailAddress());

        driver.findElement(By.name("user[password]")).sendKeys(faker.internet().password());

        System.out.println(driver.findElement(By.tagName("h2")).getText());

        //driver.findElement(By.id("user_submit")).click();

        Thread.sleep(6000);
        driver.close();

        ///////////////className/////////////

        driver.get("http://eurotech.study/");

        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("navbar-submenu-list2-item2")).click();
        Thread.sleep(1000);
       // driver.findElement(By.tagName("input")).sendKeys("eurotech@gmail.com"); // input adlı ilk tagname


        driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Test12345!");

        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.className("nav__menu-item")); // not unique, don't use
        System.out.println(element.getText());
        element.click();
*/
///////////////// linkText - tagname /////////////////////////

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement textElement = driver.findElement(By.linkText("Example 2: Element rendered after the fact"));
        textElement.click();
        Thread.sleep(3000);

        WebElement textElement2 = driver.findElement(By.tagName("button"));
        textElement2.click();

        Thread.sleep(3000);

        driver.close();


    }
}

