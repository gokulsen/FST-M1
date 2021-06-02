package activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity5_2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
        WebDriver driver=new ChromeDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Find the checkbox
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());

        //Select the checkbox
        checkboxInput.click();

        //Print status
        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());

        //Close the browser
        driver.close();

    }

}