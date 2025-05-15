package RestAssuredAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.collection.IsMapContaining.hasKey;

public class UpdateUser extends variables {
    variables variables = new variables();
    @Test(groups = "APIRestAssured",dataProvider = "userid")
    public void Updateuser (String userid)
    {
        RestAssured.baseURI = baseURI;
        Response response = (Response) RestAssured.given()
                .header(AuthType, apiKey)
                .when()
                .put(endpoint + "/" +userid)
                .then()
                .statusCode(200)
                .body("$", hasKey("id"));
    }
    @DataProvider(name = "userid")
    public Object[][] UserData() {
        return new Object[][] {
                { "2" },   // User2
        };
    }
}
