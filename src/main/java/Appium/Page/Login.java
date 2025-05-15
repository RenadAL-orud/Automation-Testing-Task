package Appium.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import Appium.Wait.wait;

public class Login extends Launchtheapp {
    wait wait = new wait();

    @AndroidFindBy (accessibility = "test-Username")
    private MobileElement UserName;
    @AndroidFindBy (accessibility = "test-Password")
    private MobileElement Password;
    @AndroidFindBy (accessibility = "test-LOGIN")
    private MobileElement LoginButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private MobileElement productsTitle;

     public void login(){

         wait.waitForElementToBeVisible(UserName);
         wait.waitForElementToBeVisible(Password);
         wait.waitForElementToBeVisible(LoginButton);
     }

     public void UserName (String username){
       UserName.sendKeys(username);

     }
    public void Password (String password){
      Password.sendKeys(password);

    }
    public void LoginButton(){
       LoginButton.click();
    }
    public boolean Verifylogin()
    {
        wait.waitForElementToBeVisible(productsTitle);
        return productsTitle.isDisplayed();


    }




}
