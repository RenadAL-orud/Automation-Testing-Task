package RestAssuredAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUser extends variables {
    variables variables=new variables();
    @Test(groups = "APIRestAssured",dataProvider = "userid")
     public void GetUser(String userid){
         RestAssured.baseURI = baseURI;
         Response response = (Response) RestAssured.given()
                 .header(AuthType, apiKey)
                 .when()
                 .put(endpoint + "/" +userid)
                 .then()
                 .statusCode(200)
                 .body("data.id",equalTo(2))
                 .body("data.email", equalTo("janet.weaver@reqres.in"))
                 .body("data.first_name", equalTo("Janet"))
                 .body("support.text", containsString("Content Caddy"));

     }
    @DataProvider(name = "userid")
    public Object[][] UserData() {
        return new Object[][] {
                { "2" },   // User2
        };
    }


}
