package Appium.TestCase;
import Appium.Page.Launchtheapp;
import Appium.Page.Productpage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Productpage  extends Launchtheapp {
   private Productpage Productpage;

   @BeforeMethod()
    public void setup(){
       Productpage =new Productpage();
   }
    @Test(description = "Product",groups = {"mobile"})
    public void VerifyProductpage(){
        Assert.assertTrue(Productpage.displayProducttitle(), "Product title not displayed");
        Assert.assertTrue(Productpage.displayProductprice() ,"Product price not displayed");
    }


}
