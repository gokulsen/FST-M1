package project;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ToDoList {
	AndroidDriver<MobileElement> driver;
	 WebDriverWait wait;
	
@BeforeClass
	public void setUp() throws MalformedURLException {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Pixel4_Emulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver,10);
        driver.get("https://www.training-support.net/selenium");
           }
 
 @Test
 public void chromeTodoList() throws InterruptedException {
    	
	 	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));        
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
		Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
        Thread.sleep(3000);
        String[] tasks= {"1.Add tasks to list","2.Get number of tasks","3.Clear the list"};
        
        for (String task : tasks) 
        {
        	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[4]/android.view.View[1]/android.widget.EditText")));
        	driver.findElementByXPath("//android.view.View[4]/android.view.View[1]/android.widget.EditText").sendKeys(task);
        	
        	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
         }
        Thread.sleep(3000);
        String addedtask1=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View").getText();
        String addedtask2=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View").getText();
        String addedtask3=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View").getText();
        Assert.assertEquals("1.Add tasks to list", addedtask1);
        Assert.assertEquals("2.Get number of tasks", addedtask2);
        Assert.assertEquals("3.Clear the list", addedtask3);
        List<MobileElement> addedTasks = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
        System.out.println("no. of tasks: " + addedTasks.size());
        Assert.assertEquals(addedTasks.size(), 4);
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[2]").click();
        Thread.sleep(3000);
        List<MobileElement> addedTasks1 = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
        System.out.println("no. of tasks: " + addedTasks1.size());
        Assert.assertEquals(addedTasks1.size(), 0);

    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}