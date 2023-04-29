package com.eurotech.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGAssertions {

    @Test
    public void test1() {
        System.out.println("verifying whether login is successful");
        String expectedTitle = "title";
        String actualTitle = "title";
        Assert.assertEquals(actualTitle, expectedTitle,"actual is not equal expected");
    }

    @Test
    public void test2() {
        String expectedTitle = "zEuro";
        String actualTitle = "Eurotech";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verifying title to start with the expectedText");
        System.out.println("test continues");
    }

    @Test
    public void test3() {
        Assert.assertFalse(0 > 1,"Asserting 0 to be greater that 1");
    }

    @Test
    public void test4() {
        Assert.assertNotEquals("Title","title");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("setting up browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("closing the browser");
    }
}
