package project;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class Activity2 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
        
        //ImplicitWait
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @Test
    public void verifyHeading() {
        // Check the title of the page
    	WebElement parentElement = driver.findElement(By.tagName("h1"));

    	 //Get the text from the description element.
    	 String heading0 = parentElement.getText();

        //Print the title of the page
        System.out.println("Page heading0 is: " + heading0);
            
       //Assertion for page title
       Assert.assertEquals("Learn from Industry Experts", heading0);
            
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}