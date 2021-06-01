package activity;

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

public class Activity6 {
	AndroidDriver<MobileElement> driver;
	 WebDriverWait wait;
	
@BeforeClass
	public void setUp() throws MalformedURLException {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Pixel4Emulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver,20);
 
        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }
 
    @Test
    public void imageScrollTest() throws InterruptedException {

    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[@text='Lazy Loading']")));

        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        Thread.sleep(3000);
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        
        Assert.assertEquals(numberOfImages.size(), 2);
        
        Thread.sleep(5000);  
      
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"helen\")"));
        Thread.sleep(3000);

        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        
        Thread.sleep(3000);

    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}