package TestRunner;




//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "/Users/punya.jain/Documents/Amazon_Training_Project_IBM/TestingAmazonWebsite/Feature_File",
    glue = "com.TestingAmazonUsingCucumber",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)


public class TestRunnerCucumber {

}
