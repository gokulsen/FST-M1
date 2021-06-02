package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
		WebDriver driver=new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");
		
		
		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-1507\"]"));
		MyAccount.click();
		
		WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91\"]/div[2]/div[2]/a")); 
		LoginButton.click();
		
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		
		driver.findElement(By.id("wp-submit")).click();
		
				
		if (driver.findElement(By.xpath("//*[@id=\"uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91\"]/div[2]/div[4]/a")).isDisplayed())
		{
			System.out.println("User is Logged In");
			
		}
		else
		{
			
			System.out.println("User Not Logged In");
		}
		driver.close();
	}

}