package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_3 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
        WebDriver driver=new ChromeDriver();
        //Open the browser
        driver.get("https://www.training-support.net/selenium/simple-form");
        
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        
        //Find the input fields
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        //Enter text
        firstName.sendKeys("Gokula");
        lastName.sendKeys("Krishnan");
        
        //Enter the email
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        
        //Enter the contact number
        driver.findElement(By.id("number")).sendKeys("1234567890");
        
        //Click Submit
        driver.findElement(By.cssSelector(".ui.green.button")).click();
    
        //Close the browser
        driver.close();
    }
}