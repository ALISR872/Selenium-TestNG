package com.eurotech.Exercise;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Exer_1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://codingbat.com/java");

        WebElement userName = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td[2]/input"));
        userName.sendKeys("ali.serdan89@gmail.com");

        driver.findElement(By.name("pw")).sendKeys("As.014530");

        driver.findElement(By.name("dologin")).click();

        WebElement startLogic = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/table/tbody/tr[3]/td[1]/div/a/span"));
        startLogic.click();

        driver.findElement(By.xpath("/html/body/div[4]/div/div/table/tbody/tr[4]/td[3]/a")).click();
        Thread.sleep(1000);
        WebElement answerArea = driver.findElement(By.xpath("//*[@id=\"ace_div\"]/textarea"));

        answerArea.clear();
        answerArea.sendKeys("\nif(n%20 == 18 || n%20 == 19){\n" +
                "return true;\n}else{\nreturn false;");

        driver.findElement(By.xpath("/html/body/div[4]/div/div/table/tbody/tr/td[1]/p/button")).click();


    }
}
