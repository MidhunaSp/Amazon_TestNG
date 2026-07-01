package com.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        File src = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            String fileName = result.getName() + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(src, new File("./screenshots/" + fileName));
            System.out.println("Screenshot captured on failure: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }
}