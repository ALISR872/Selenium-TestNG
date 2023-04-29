package com.eurotech.tests.day18_extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportsDemo {

    // this class is used for building reports
    ExtentReports report;

    // this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test, enable adding logs, outhors and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp() {
        // initialize the class
        report = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        // initialize the html report to the report object
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Eurotech Smoke Test");

        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "AliSR");

    }

    @Test
    public void test1() {
        // give a name to the current test
        extentLogger = report.createTest("TC001 Login Test");

        // test stage
        extentLogger.info("Open the browser");
        extentLogger.info("Navigate to URL: http://eurotech.study/login");
        extentLogger.info("Login as a Teacher");
        extentLogger.info("Enter Teacher username");
        extentLogger.info("Enter Teacher password");
        extentLogger.info("Click login Button");
        extentLogger.info("Verify User is logged in");
        extentLogger.info("TC001 Login Test is passed");
    }

    @AfterMethod
    public void tearDown() {
        // this is when the report is actually created
        report.flush();
    }
}
