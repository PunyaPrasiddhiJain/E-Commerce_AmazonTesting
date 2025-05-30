package com.TestAmazonUsingTestNG;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

//import java.time.Duration;

public class AmazonRegisterTest extends BaseClassTestNG {


    @Test
    public void registerOnAmazon() {
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        // Fill form
        driver.findElement(By.id("createAccountSubmit")).click();
        driver.findElement(By.id("ap_email_login")).sendKeys("jdjbcdhc@gmail.com");


        // Submit the form
        driver.findElement(By.id("continue")).click();
        
        driver.findElement(By.className("a-button-input")).click();
        
        driver.findElement(By.id("ap_phone_number")).sendKeys("7428730894");
        driver.findElement(By.id("ap_customer_name")).sendKeys("Veeru");
        driver.findElement(By.id("ap_password")).sendKeys("123P@09");
        driver.findElement(By.id("continue")).click();

         //You will be redirected to OTP page — cannot proceed without real OTP
//        WebElement heading = driver.findElement(By.tagName("h1"));
//        assert heading.getText().contains("Authentication required") ||
//               heading.getText().contains("Verify mobile number");
    }

    @AfterClass
    public void tearDown() {
        
    	driver.quit();
    }
}