package com.TestingAmazonUsingCucumber;


import io.cucumber.java.en.*;

import org.openqa.selenium.By;

public class RegisterSteps{

    @Given("I navigate to Amazon registration page")
    public void iNavigateToAmazonRegistrationPage() throws InterruptedException {
    	BaseCucumberClass.initializeDriver();
    	BaseCucumberClass.driver.get("https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Fhomepage.html%2F%3Fie%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    	Thread.sleep(2000);
    	BaseCucumberClass.takeScreenshot("01_NavigateToRegistration");
    }

    @When("I fill the registration form with name {string}, mobile {string}, email {string}, and password {string}")
    public void iFillTheRegistrationForm(String name, String mobile, String email, String password) throws InterruptedException {
    	BaseCucumberClass.driver.findElement(By.id("ap_customer_name")).sendKeys(name);
    	Thread.sleep(2000);
    	BaseCucumberClass.takeScreenshot("02_FillName");
//    	BaseCucumberClass.driver.findElement(By.id("ap_email")).sendKeys(email);
//    	BaseCucumberClass.takeScreenshot("03_FillEmail");
    	BaseCucumberClass.driver.findElement(By.id("ap_phone_number")).sendKeys(mobile);
    	Thread.sleep(2000);
    	BaseCucumberClass.takeScreenshot("04_FillMobile");
    	BaseCucumberClass.driver.findElement(By.id("ap_password")).sendKeys(password);
    	Thread.sleep(2000);
    	BaseCucumberClass.takeScreenshot("05_FillPassword");
    	BaseCucumberClass.driver.findElement(By.id("continue")).click();
    	Thread.sleep(2000);
    	BaseCucumberClass.takeScreenshot("06_ClickContinue");
    }

    @Then("I should be on OTP verification page")
    public void iShouldBeOnOtpVerificationPage() throws InterruptedException {
    	Thread.sleep(2000);
    	BaseCucumberClass.takeScreenshot("07_OTPPage");
        assert BaseCucumberClass.driver.getPageSource().contains("Authentication required") || 
        BaseCucumberClass.driver.getPageSource().contains("Verify mobile number");
        //BaseCucumberClass.quitDriver();
    }
}