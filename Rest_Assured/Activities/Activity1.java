package Activity;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Activity1 {

    String baseUri;

    @BeforeClass
    public void beforeAll(){
        baseUri = "https://petstore.swagger.io/v2/pet";
    }

    @Test(priority = 1)
    public void postRequest(){

        HashMap<String,String> reqBody = new HashMap<String,String>();
        reqBody.put("id","12026");
        reqBody.put("name","Victor");
        reqBody.put("status","available");
        Response response = given().contentType(ContentType.JSON)
                                   .body(reqBody).when().post(baseUri);

        String body = response.body().asPrettyString();
        System.out.println(body);

        //Add assertion
        response.then().body("id", equalTo(12026));
        response.then().body("name", equalTo("Victor"));
        response.then().body("status", equalTo("available"));

    }

    @Test(priority = 2)
    public void getRequest(){

        Response response =
                given().contentType(ContentType.JSON)
                        .when().pathParam("petId", "12026")
                        .get(baseUri + "/{petId}");

        String body = response.body().asPrettyString();
        System.out.println(body);

        //Add assertion
        response.then().body("id", equalTo(12026));
        response.then().body("name", equalTo("Victor"));
        response.then().body("status", equalTo("available"));
    }

    @Test(priority = 3)
    public void deleteRequest(){

        Response response =
                given().contentType(ContentType.JSON)
                        .when().pathParam("petId", "12026")
                        .delete(baseUri + "/{petId}");

        String body = response.body().asPrettyString();
        System.out.println(body);

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("12026"));

    }

}
