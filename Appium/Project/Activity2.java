package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class googleKeep {
	
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("deviceName", "Pixel_4_Android_Pie");
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("appPackage", "com.google.android.keep");
    	caps.setCapability("appActivity", ".activities.BrowseActivity");
    	caps.setCapability("noReset", true);

    	try {
			// Instantiate Appium Driver
			URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(appServer, caps);
			wait = new WebDriverWait(driver, 5);
			
			// Wait for Keep App home page to load
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("action_bar_root")));
			
			// Assert Keep home page
			MobileElement pageLayout = driver.findElementById("action_bar_root");
			Assert.assertTrue(pageLayout.isDisplayed());
    	}	
    	catch (MalformedURLException e) {
    		e.printStackTrace();
    	}	
    }
	    	
	  @Test
	  public void addTask() {
		  
		  	// wait for add new notes button
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
			// click the add new notes (+) button
			driver.findElementById("new_note_button").click();
			// wait for new page - to add notes title and description
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("browse_note_interior_content")));
			// add title
			MobileElement sendTitle = driver.findElementById("editable_title");
			sendTitle.sendKeys("1 - Notes Title");
			// add description
			MobileElement sendDescription = driver.findElementById("edit_note_text");
			sendDescription.sendKeys("1 - Notes Description");
			// click back button to go back to home page
			driver.findElementByAccessibilityId("Open navigation drawer").click();
			// wait until home page
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("action_bar_root")));
			// get title and description 
			String verifyTitle = driver.findElementById("index_note_title").getText();
			String verifyDescription = driver.findElementById("index_note_text_description").getText();
			// assert
			assertEquals(verifyTitle,"1 - Notes Title");
			assertEquals(verifyDescription,"1 - Notes Description");
	  }
		  
	  @AfterClass
	  public void tearDown() {
	      driver.quit();
	  }	    
}
