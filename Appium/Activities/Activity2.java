package activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
 
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity2 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_4_Android_Pie");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testSearchAppium() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.training-support.net/");

        String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
        System.out.println("Title on Homepage: " + pageTitle);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
        //MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
        MobileElement aboutButton = driver
        		.findElementByXPath("//android.view.View[4][@resource-id='about-link']");
        aboutButton.click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        String newPageTitle = driver
                .findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]")
                .getText();
        
        System.out.println("Title on new page: " + newPageTitle);

        // Assertions
        Assert.assertEquals(pageTitle, "Training Support");
        Assert.assertEquals(newPageTitle, "About Us");
        
        
        
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}