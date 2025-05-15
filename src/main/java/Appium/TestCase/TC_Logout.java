package Appium.TestCase;
import Appium.Page.Launchtheapp;
import Appium.Page.Logout;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Logout extends Launchtheapp {
    private Logout Logout;

    @BeforeMethod
    public void setup(){
        Logout= new Logout();
    }
@Test(groups = {"mobile"},description = "logout")
    public void Logout(){
        Logout.MenuButton();
        Logout.LogoutButton();
    }



}
