package activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity4 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeTest
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("deviceName", "Pixel_4_Android_Pie");
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("appPackage", "com.android.contacts");
    	caps.setCapability("appActivity", ".activities.PeopleActivity");
    	caps.setCapability("noReset", true);

    	// Instantiate Appium Driver
    	URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
    	driver = new AndroidDriver<MobileElement>(appServer, caps);
    	wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addContact() {
        driver.findElementById("com.android.contacts:id/floating_action_button").click();
        MobileElement firstName =  driver.findElementByXPath("//android.widget.EditText[1][@text='First name']");
        MobileElement lastName =  driver.findElementByXPath("//android.widget.EditText[2][@text='Last name']");
        MobileElement phoneNumber =  driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[@text='Phone']");
        
        firstName.sendKeys("Aaditya");
        lastName.sendKeys("Varma");
        phoneNumber.sendKeys("9991284782");
        
        driver.findElementById("editor_menu_save_button").click();
    	
        // Wait for contact card to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
 
        // Assertion
        MobileElement mobileCard = driver.findElementById("toolbar_parent");
        Assert.assertTrue(mobileCard.isDisplayed());
        
        String getConcactName = driver.findElementById("com.android.contacts:id/large_title").getText();
        String getConcactNumber = driver.findElementById("com.android.contacts:id/header").getText();
        
        Assert.assertEquals(getConcactName, "Aaditya Varma");
        Assert.assertEquals(getConcactNumber, "(999) 128-4782");
            
    }

    @AfterTest
    public void afterClass() {
        driver.quit();
    }
}