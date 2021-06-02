package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity9 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
		WebDriver driver = new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");
		
		driver.findElement(By.id("menu-item-1508")).click();
		driver.findElement(By.xpath("//*[@id=\"post-69\"]/a/img")).click();
		
		driver.findElement(By.xpath("//*[@id=\"learndash_post_69\"]/div/div[1]/div[3]/div/div/a")).click();
		
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		
		driver.findElement(By.id("wp-submit")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"ld-expand-83\"]/div[1]/a/div[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"ld-table-list-item-175\"]/a/span")).click();
		
		
		System.out.println("Current Page Title: " + driver.getTitle());
		
		driver.close();
		

	}

}