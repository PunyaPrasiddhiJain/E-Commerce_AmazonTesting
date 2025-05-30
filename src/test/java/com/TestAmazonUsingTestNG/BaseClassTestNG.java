package com.TestAmazonUsingTestNG;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClassTestNG {
    protected static WebDriver driver;
    //WebDriverWait wait;
    

    @BeforeClass
    public void setUp() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @AfterClass
    public void tearDown() {
        // Do not quit here if you want to keep the browser open across tests
        // You can quit it from the last class if needed
    }
}