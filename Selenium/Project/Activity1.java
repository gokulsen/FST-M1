package project;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Activity1 {
public static void main (String args[]) {
	
	   System.setProperty("webdriver.chrome.driver", "C:\\\\Gokul\\\\Full Stack Tester\\\\Selenium\\\\Chrome Driver\\\\chromedriver.exe"); 
	    WebDriver driver=new ChromeDriver();  
	    //driver.navigate().to("http://www.google.com/");  
		driver.get("https://alchemy.hguy.co/lms");

		String maintitle = driver.getTitle();
				if (maintitle.equals("Alchemy LMS – An LMS Application"))
				{
					System.out.println("Main Title matched");
				}
				else { 
					System.out.println("Main Title not matched");
				}
				
		driver.close();		
	}
}
