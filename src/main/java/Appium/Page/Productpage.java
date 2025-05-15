package Appium.Page;

import Appium.Wait.wait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class Productpage {
    wait wait = new wait();

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Title']")
    private MobileElement productDetailTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private MobileElement productDetailPrice;

    public void Productpage(){
        wait.waitForElementToBeVisible(productDetailTitle);
        wait.waitForElementToBeVisible(productDetailPrice);

    }

    public  boolean displayProducttitle(){
        return productDetailTitle.isDisplayed();
    }

    public boolean displayProductprice(){
        return productDetailPrice.isDisplayed();
    }


}

