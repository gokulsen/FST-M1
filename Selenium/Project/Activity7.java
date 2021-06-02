package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
		WebDriver driver = new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");
		
		driver.findElement(By.id("menu-item-1508")).click();
		
		 List<WebElement> cols=driver.findElements(By.xpath("//div[@class='caption']/h3"));
		 System.out.println("Number of Courses on the page: "+ cols.size());
		
		driver.close();
	}

}