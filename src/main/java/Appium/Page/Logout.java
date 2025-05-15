package Appium.Page;
import Appium.Wait.wait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Logout extends  Launchtheapp{
    Appium.Wait.wait wait = new wait();
    @AndroidFindBy(xpath = "//*[@content-desc='test-Menu']")
    private MobileElement Menu;
    @AndroidFindBy (accessibility = "test-LOGOUT")
    private MobileElement LogoutButton;
    public void Logout(){
        wait.waitForElementToBeVisible(Menu);
    }
    public void MenuButton(){
      Menu.click();
    }
    public void LogoutButton(){
        wait.waitForElementToBeVisible(LogoutButton);
        LogoutButton.click();


    }

}

