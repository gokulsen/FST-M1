package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Gokul\\Full Stack Tester\\Selenium\\Chrome Driver\\chromedriver.exe");  
		WebDriver driver=new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");
				
		WebElement element = driver.findElement(By.xpath("//*[@id=\"uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810\"]/div/div/div/div[2]/h3"));
		
		System.out.println(element.getText());
		
		if (element.getText().equals("Actionable Training")) 
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