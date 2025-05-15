package RestAssuredAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.collection.IsMapContaining.hasKey;

public class CreateUser extends variables{
     variables variables = new variables();
 @Test(groups = "APIRestAssured")
    public void createPostWithValidations() {
        RestAssured.baseURI = baseURI;
        Response response = (Response) RestAssured.given()
                .header(AuthType, apiKey)
                .then()
                .statusCode(201) // ✅ Validate status code
                .body("$", hasKey("id"))
                .body("$", hasKey("createdAt"));

    }
}
