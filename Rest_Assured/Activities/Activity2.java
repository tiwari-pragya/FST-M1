package Activity;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {

    String baseUri;

    @BeforeClass
    public void beforeAll(){
        baseUri = "https://petstore.swagger.io/v2/user";
    }

    @Test(priority = 1)
    public void postRequest() throws IOException {

        FileInputStream inputJSON = new FileInputStream("src/test/java/resources/Activity2_Input.json");
        String reqBody = new String(inputJSON.readAllBytes());
        Response response = given().contentType(ContentType.JSON)
                .body(reqBody).when().post(baseUri);

        String body = response.body().asPrettyString();
        System.out.println(body);

        //Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("15003"));
    }

    @Test(priority = 2)
    public void getRequest(){

        File outputJSON = new File("src/test/java/resources/Activity2_Output.json");
        Response response =
                given().contentType(ContentType.JSON)
                        .when().pathParam("username", "andycase")
                        .get(baseUri + "/{username}");

        String resBody = response.getBody().asPrettyString();

        try {
            // Create JSON file
            outputJSON.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Assertion
        response.then().body("id", equalTo(15003));
        response.then().body("username", equalTo("andycase"));
        response.then().body("firstName", equalTo("Andy"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("andycase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763470"));
    }

    @Test(priority = 3)
    public void deleteRequest(){

        Response response =
                given().contentType(ContentType.JSON)
                        .pathParam("username", "andycase")
                        .when().delete(baseUri + "/{username}");

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("andycase"));


    }

}
