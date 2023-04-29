package com.eurotech.tests.day7_TestNG;

import org.testng.annotations.*;

public class testNGAnnotations {
    @Test
    public void test1() {

        System.out.println("this is test1");
        System.out.println("some verifications");
    }

    @Test
    public void test2() {
        System.out.println("this is test2");
        System.out.println("some verifications");
    }



    @BeforeMethod
    public void setUp(){
        System.out.println("setting up browser");
        System.out.println("navigate the URL");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("closing the browser");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("this is before class");
    }

    @AfterClass
    public void afterClass() {

    }
}
