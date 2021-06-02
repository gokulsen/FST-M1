package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity8 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
		WebDriver driver = new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");
		
		driver.findElement(By.id("menu-item-1506")).click();
		
		
		driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Gaurank Arora");
		driver.findElement(By.id("wpforms-8-field_1")).sendKeys("gaurankarora@in.ibm.com");
		driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Selenium");
		driver.findElement(By.id("wpforms-8-field_2")).sendKeys("I have a doubt in Selenium Course. Please Help !!! ");
		
		
		driver.findElement(By.id("wpforms-submit-8")).click();
		
		
		System.out.println("Page Response: " + driver.findElement(By.xpath("//*[@id=\"wpforms-confirmation-8\"]/p")).getText());
		
		driver.close();
	}

}