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


public class Activity3 {
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
    public void infoBox() {
        // Check the title of the page
    	WebElement parentElement = driver.findElement(By.tagName("h3"));

    	 //Get the text from the description element.
    	 String infoBoxName = parentElement.getText();

        //Print the title of the page
        System.out.println("Page infoBoxName is: " + infoBoxName);
            
       //Assertion for page title
       Assert.assertEquals("Actionable Training", infoBoxName);
            
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}