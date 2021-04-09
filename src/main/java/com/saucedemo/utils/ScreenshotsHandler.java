package com.saucedemo.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsHandler {

    public static void takeSnapShot(WebDriver webdriver, String filePath, String fileName) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destPath = new File(filePath);
        if (!destPath.exists()) {
            destPath.mkdirs();
        }
        File destFile = new File(filePath + "\\" +fileName);
        FileUtils.copyFile(SrcFile, destFile);
    }
}