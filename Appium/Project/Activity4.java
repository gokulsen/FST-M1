package project;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SimpleLogin {
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
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver,20);
        
}
@BeforeMethod
public void openLogInURL() {
        driver.get("https://www.training-support.net/selenium");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		driver.findElementByXPath("//android.view.View[contains(@text,'Login')]").click();
           }
 @Test(priority=1)
 public void chromeLoginSuccessful() throws InterruptedException {
    	              
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[1]")));
        driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("admin");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("password");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
        String msg=driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();
        System.out.println(msg);
        Assert.assertEquals("Welcome Back, admin", msg);
                      		       
    }
    
    @Test(priority=2)
    public void chromeLoginInvalidCredentials() throws InterruptedException {
    	              
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[1]")));
        driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("jodha");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("akbar123");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
        String msg=driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();
        System.out.println(msg);
        Assert.assertEquals("Invalid Credentials", msg);
                      		       
    }
 
    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}