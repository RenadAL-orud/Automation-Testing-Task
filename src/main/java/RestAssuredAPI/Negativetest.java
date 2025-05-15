package RestAssuredAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;

public class Negativetest  extends  variables{
    variables variables = new variables();
    @Test(groups = "APIRestAssured")
    public void createNegativetest() {
        //401 Unauthorized for  the API
        baseURI = baseURI;
        Response response = (Response) RestAssured.given()
                .header(AuthType, NegativeapiKey)
                .then()
                .statusCode(401) // ✅ Validate status code
                .body("error", containsString("Missing API key."));
    }
    }
