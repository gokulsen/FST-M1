package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
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

public class googleKeepRemainder {
	
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
			wait = new WebDriverWait(driver, 10);
			
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
	  public void addRemainder() throws InterruptedException {
		  
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
		   driver.findElementByAccessibilityId("New text note").click();
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));
		   driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Title 1- Remainder");
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/edit_note_text")));
		   driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Description - Adding Reminder");
		   Thread.sleep(3000);
		   driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Reminder\"]").click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/time_spinner")));
		   driver.findElementById("com.google.android.keep:id/time_spinner").click();
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[1][@text='Night']")));
		   driver.findElementByXPath("//android.widget.TextView[1][@text='Night']").click();
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/save")));
		   driver.findElementById("com.google.android.keep:id/save").click();
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer")));
		   driver.findElementByAccessibilityId("Open navigation drawer").click();
		   Thread.sleep(5000);
		   driver.findElementByAccessibilityId("Open navigation drawer").click();
		   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.LinearLayout[2]/android.widget.TextView[@text='Reminders']")));
		   driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.TextView[@text='Reminders']").click();
		   Thread.sleep(3000);
		   wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.LinearLayout/android.widget.TextView[1]")));
		   String result=driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView[1]").getText();
		   Thread.sleep(3000);
		   System.out.println(result);
		   Assert.assertEquals("Title 1- Remainder\"",result);
	  }
 
	  @AfterClass
	  public void tearDown() {
	      driver.quit();
	  }
    
}
