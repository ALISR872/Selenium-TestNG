package com.eurotech.tests.day12_actions_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void fileUpload() {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileBtn = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileBtn.sendKeys("/Users/Ayşenur/Desktop/EuroTechBatch6.txt");

        driver.findElement(By.cssSelector("#file-submit")).click();

        String actualText = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expectedText = "EuroTechBatch6.txt";

        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void test2() throws FileNotFoundException {
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");
        String filePath= "src/test/resources/EurotechBatch6.txt";
        driver.get("https://the-internet.herokuapp.com/upload");

        String fullPath = projectPath +"/"+ filePath;

       // File file = new File("EurotechBatch6.txt");
       // Scanner sc = new Scanner(file);

        WebElement chooseFileBtn = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileBtn.sendKeys(fullPath);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
