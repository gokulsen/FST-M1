package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4_1  {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
        WebDriver driver=new ChromeDriver();
        //And now use this to visit the website
        driver.get("https://www.training-support.net");

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Find the "Get Started!" link and click it
        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();

        //Print title of new page
        System.out.println("Heading is: " + driver.getTitle());

        //Close the browser
        driver.close();

    }

}