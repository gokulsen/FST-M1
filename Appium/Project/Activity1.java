package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class googleTasks {
	
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("deviceName", "Pixel_4_Android_Pie");
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("appPackage", "com.google.android.apps.tasks");
    	caps.setCapability("appActivity", ".ui.TaskListsActivity");
    	caps.setCapability("noReset", true);

    	try {
			// Instantiate Appium Driver
			URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(appServer, caps);
			wait = new WebDriverWait(driver, 5);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("action_bar_root")));
			
			MobileElement pageLayout = driver.findElementById("action_bar_root");
			Assert.assertTrue(pageLayout.isDisplayed());
    	}	
    	catch (MalformedURLException e) {
    		e.printStackTrace();
    	}	
    }
	    	
	  @Test
	  public void addTask() {
		  
		  String[] tasksToAdd = {
				  "Task 1 - My First Task in Google Task",
				  "Task 2 - My Second Task in Google Task",
				  "Task 3 - My Third Task in Google Task"
		  };
		  
		  for (String taskToAdd : tasksToAdd) {
				wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
				  
				driver.findElementById("tasks_fab").click();
				
				wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
				
				MobileElement sendTask = driver.findElementById("add_task_title");
				sendTask.sendKeys(taskToAdd);
				
				driver.findElementById("add_task_done").click();				

		  }
		  
			wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));
			List<MobileElement> tasksAdded = driver.findElementsById("task_name");		
			assertEquals(tasksAdded.get(3).getText(), "Task 1 - My First Task in Google Task");
	  }
		  
	  @AfterClass
	  public void tearDown() {
	      driver.quit();
	  }	    
}
