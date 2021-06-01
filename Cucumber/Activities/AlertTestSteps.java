package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertTestSteps {
	 	WebDriver driver;
	    WebDriverWait wait;
	    Alert alert;
	
	@Given("^User is on the page$")
	public void user_is_on_the_page()  {
	    // Write code here that turns the phrase above into concrete actions
		 driver = new FirefoxDriver();
	     wait = new WebDriverWait(driver, 10);
	 
	        //Open browser
	      driver.get("https://www.training-support.net/selenium/javascript-alerts");
	}

	@When("^User clicks the Simple Alert button$")
	public void user_clicks_the_Simple_Alert_button()  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("#simple")).click();   
	}

	@Then("^Alert opens$")
	public void alert_opens()  {
	    // Write code here that turns the phrase above into concrete actions
		 alert = driver.switchTo().alert();   
	}

	@Then("^Read the text from it and print it$")
	public void read_the_text_from_it_and_print_it()  {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Alert says: " + alert.getText());  
	}

	@Then("^Close the alert$")
	public void close_the_alert()  {
	    // Write code here that turns the phrase above into concrete actions
		 alert.accept();
	    
	}

	@Then("^Close Browser$")
	public void close_Browser()  {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

	@When("^User clicks the Confirm Alert button$")
	public void user_clicks_the_Confirm_Alert_button()  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("#confirm")).click();   
	}

	@Then("^Close the alert with Cancel$")
	public void close_the_alert_with_Cancel()  {
	    // Write code here that turns the phrase above into concrete actions
		alert.dismiss();
	}

	@When("^User clicks the Prompt Alert button$")
	public void user_clicks_the_Prompt_Alert_button()  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("#prompt")).click();   
	}

	@Then("^Write a custom message in it$")
	public void write_a_custom_message_in_it()  {
	    // Write code here that turns the phrase above into concrete actions
		alert.sendKeys("Custom message");
	    
	}
}