package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/IBMADMIN/Documents/Automation/Drivers/chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");
				
		WebElement element = driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3"));
		
		System.out.println(element.getText());
		
		if (element.getText().equals("Email Marketing Strategies")) 
				{
			System.out.println("Title of the first info box is matching");
			
		}
		else
		{
			System.out.println("Title of the first info box is not matching!!");
		}
		
		driver.close();
	}

}