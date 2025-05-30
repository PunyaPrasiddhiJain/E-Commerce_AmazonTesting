package com.TestAmazonUsingTestNG;




import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AmazonSignIn extends BaseClassTestNG{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test
    public void signInAndAddToCart() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

        // Sign in
        driver.findElement(By.id("ap_email")).sendKeys("punyajain202@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("MYparant@2002");
        driver.findElement(By.id("signInSubmit")).click();

        //Thread.sleep(20000); // If OTP required manually

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Wait and click the first product (open in same tab)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(2)")));

        List<WebElement> products = driver.findElements(By.cssSelector(".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(2)"));
        if (!products.isEmpty()) {
            WebElement firstProduct = products.get(0);

            // Remove target="_blank" to avoid new tab
            js.executeScript("arguments[0].removeAttribute('target')", firstProduct);
            firstProduct.click();
        } else {
            System.out.println("No products found");
            return;
        }

        // Add to cart
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[15]/div/div/div/div[1]/div[2]/div/div[2]/div/form/div[6]/span/span/input")).click();

        // Optional: navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-cart"))).click();

        System.out.println("Product added to cart successfully.");
    }
}

//driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");