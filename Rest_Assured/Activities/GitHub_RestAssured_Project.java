package Project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AnyOf.anyOf;
//import static org.hamcrest.Matchers.anyOf;

public class GitHub_RestAssured_Project {

    RequestSpecification reqSpec;
    String sshKey;
    int id;

    @BeforeClass
    public void beforeAll(){

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.github.com")
                .addHeader("Authorization", "token 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")
                .build();
    }

    @Test(priority = 1)
    public void postRequest(){

        HashMap<String, String> reqBody = new HashMap<String, String>();
        reqBody.put("title", "testKey");
        reqBody.put("key", "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFcH9oGzK3JqrhTy2/k+vqwe4kMPv6FUL139rnXmx1su");

        ///user/keys
        Response response =
                 given().spec(reqSpec)
                        .body(reqBody)
                         .when().post("/user/keys");

        // Print response
        String body = response.getBody().asPrettyString();
        //System.out.println(body);
        id = Integer.parseInt(response.then().extract().path("id").toString());
        System.out.println("Id fetched from json" + id);
        Assert.assertEquals(response.getStatusCode(), 201, "Status code does not match");
    }

    @Test(priority = 2)
    public void getRequest(){

        Response response =
                given().spec(reqSpec)
                        .pathParam("keyId", id)
                .when().get("/user/keys/{keyId}");

        // Print response
        String body = response.getBody().asPrettyString();
        System.out.println(body);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code does not match");
        //response.then().statusCode(200);

    }

    @Test(priority = 3)
    public void deleteRequest(){

        Response response =
                given().spec(reqSpec)
                        .pathParam("keyId", id)
                        .when().delete("/user/keys/{keyId}");

        response.then().statusCode(anyOf(is(200), is(204)));
        Reporter.log("ID deleted successfully" + response.asPrettyString());
        System.out.println("ID deleted successfully" + response.asPrettyString());
    }
}
