package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps {
	
	WebDriver driver;
    WebDriverWait wait;
    
	@Given("^User is on Login page$")
	public void user_is_on_Login_page()  {
	    // Write code here that turns the phrase above into concrete actions
		 driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 10);
	        driver.get("https://www.training-support.net/selenium/login-form");
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password()  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	}

	@Then("^Read the page title and confirmation message$")
	public void read_the_page_title_and_confirmation_message() {
	    // Write code here that turns the phrase above into concrete actions
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
	        
	        //Read the page title and heading
	        String pageTitle = driver.getTitle();
	        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
	        
	        //Print the page title and heading
	        System.out.println("Page title is: " + pageTitle);
	        System.out.println("Login message is: " + confirmMessage);
	}

	@Then("^Close the Browser$")
	public void close_the_Browser() {
	    // Write code here that turns the phrase above into concrete actions
		  driver.close();
	    
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String uname, String pwd)  {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.id("username")).sendKeys(uname);
        //Enter password
        driver.findElement(By.id("password")).sendKeys(pwd);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
	    	}



}