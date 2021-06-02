package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
		WebDriver driver=new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"uagb-infobox-74cd79b6-b855-4e72-81bc-e70591de1896\"]/div/div/div/div[1]/h1"));
		
		
		System.out.println(element.getText());
		
		if (element.getText().equals("Learn from Industry Experts"))
		{
			System.out.println("Main Heading matched");
		}
		else { 
			System.out.println("Main Heading not matched");
		}
		
		//System.out.println(element.getText());

		driver.close();
		
	}

}