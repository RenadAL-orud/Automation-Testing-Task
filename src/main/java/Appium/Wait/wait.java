package Appium.Wait;

import Appium.Page.Launchtheapp;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class wait extends Launchtheapp {

    public void waitForElementToBeVisible(MobileElement mobileElement) {
        WebDriverWait wait = new WebDriverWait(driver, (4000));
        wait.until(ExpectedConditions.visibilityOf(mobileElement));


    }
    public void implicitlyWait() {

    driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    }


}