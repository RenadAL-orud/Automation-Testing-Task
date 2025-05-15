package Appium.TestCase;

import Appium.Page.Launchtheapp;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Appium.Page.Login;
public class TC_Login extends Launchtheapp {
    private Login Login;

    @BeforeMethod
    public void setup(){
        Login= new Login();
        }

    @Test(dataProvider = "loginData",description = "login" ,groups = {"mobile"})
    public void login() {


        Login.UserName("username");
        Login.Password ("password");
        Login.LoginButton();
        Assert.assertTrue(Login.Verifylogin(), "Login failed: 'PRODUCTS' not displayed.");

    }

    @DataProvider(name = "loginData")
    public Object[][] createLoginData() {
        return new Object[][] {
                { "standard_user", "secret_sauce" },

        };
    }



}