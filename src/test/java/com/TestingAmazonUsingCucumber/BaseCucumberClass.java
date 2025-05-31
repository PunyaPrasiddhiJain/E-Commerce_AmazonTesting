package com.TestingAmazonUsingCucumber;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseCucumberClass {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void initializeDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
    }

//    public static void initializeDriver() {
//        if (driver == null) {
//            try {
//                // URL of the Selenium Grid hub
//                URL gridUrl = new URL("http://192.168.50.160:4444"); // Change if running Grid remotely
//
//                // Define desired capabilities or options
//                FirefoxOptions options = new FirefoxOptions();
//                options.setCapability("browserName", "firefox");
//
//                // Initialize RemoteWebDriver with the Grid hub URL and options
//                driver = new RemoteWebDriver(gridUrl, options);
//                driver.manage().window().maximize();
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//            } catch (MalformedURLException e) {
//                throw new RuntimeException("Malformed Grid URL: " + e.getMessage());
//            }
//        }
//    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static void takeScreenshot(String stepName) {
    	new File("screenshots").mkdirs();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File dest = new File("screenshots/" + stepName + "_" + timestamp + ".png");
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}