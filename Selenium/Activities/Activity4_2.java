package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4_2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
        WebDriver driver=new ChromeDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/simple-form");

        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        //Find the input fields and enter text
        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));

        firstName.sendKeys("Gokula");
        lastName.sendKeys("Krishnan");

        //Enter the email
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("test@example.com");

        //Enter the contact number
        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("1234567890");

        //Enter Message
        driver.findElement(By.xpath("//textarea")).sendKeys("This is my message");

        //Click Submit
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();
        

        //Close the browser
        driver.close();

    }
}