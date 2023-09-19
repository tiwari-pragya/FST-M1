package Activity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

public class Activity3 {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;

    @BeforeClass
    public void setUp() {
        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();

        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] petInfoProvider() {
        Object[][] testData = new Object[][] {
                { 12032, "Tiger", "alive" },
                { 12033, "Panther", "alive" }
        };
        return testData;
    }

    @Test(priority=1)
    public void addPets() {
        HashMap<String,String> reqBody = new HashMap<String,String>();
        reqBody.put("id","12032");
        reqBody.put("name","Tiger");
        reqBody.put("status","alive");

        Response response = given().spec(reqSpec)
                            .body(reqBody)
                            .when().post();

        reqBody.clear();
        reqBody.put("id","12033");
        reqBody.put("name","Panther");
        reqBody.put("status","alive");
        response = given().spec(reqSpec)
                .body(reqBody)
                .when().post();

        response.then().spec(resSpec);
    }

    @Test(dataProvider = "petInfoProvider", priority=2)
    public void getPets(int id, String name, String status) {
        Response response = given().spec(reqSpec)
                .pathParam("petId", id)
                .when().get("/{petId}");


        System.out.println(response.asPrettyString());
        // Assertions
        response.then()
                .spec(resSpec)
                //.body("name", equalTo(name));
                .body("status", equalTo(status));
    }


    @Test(dataProvider = "petInfoProvider", priority=3)
    public void deletePets(int id, String name, String status) {
        Response response = given().spec(reqSpec)
                .pathParam("petId", id)
                .when().delete("/{petId}");

        // Assertions
        response.then().body("code", equalTo(200));
    }


}
