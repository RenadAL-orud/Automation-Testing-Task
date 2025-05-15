package Appium.Page;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Launchtheapp {
    protected FileInputStream inputStream ;
    protected static AppiumDriver<MobileElement> driver;
    protected Properties properties;
    protected File androidApp;

    public Launchtheapp()
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @Parameters({"deviceName"})

    @BeforeTest
    public void  beforeClass(@Optional("defaultDeviceName") String deviceName){
        File propertiesfile = new File("src/main/resources/config/config.properties");
        try {
            inputStream = new FileInputStream(propertiesfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        properties =new Properties();
        try {

            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        androidApp= new File("src/main/resources/app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // Desired Capabilities for Android Emulator/Device
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set device capabilities
        caps.setCapability("deviceName", "deviceName");  // Replace with your emulator or device name
        caps.setCapability("platformName", properties.getProperty("platformName"));  // Platform is Android
        caps.setCapability("platformVersion",properties.getProperty("platformVersion"));// Set Android version
        caps.setCapability("appPackage", properties.getProperty("appPackage")); // Your app package
        caps.setCapability("appActivity", properties.getProperty("appActivity")); // Your app's activity
        caps.setCapability("noReset", true); // Optional: set to true to keep app state between tests
       // caps.setCapability("app", androidApp.getAbsolutePath());
        try {
            driver = new AndroidDriver<>(new URL(properties.getProperty("URL")), caps);
            driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);










        } catch (MalformedURLException e) {

            throw new RuntimeException(e);
        }


    }
    @AfterTest
    public void AfterClass(){


        driver.quit();


    }

}
