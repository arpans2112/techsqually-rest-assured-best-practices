package scenarios;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class getRequestTest {


    public static void main(String[] args) {


        RestAssured.baseURI = "http://google.com";

        given().
                when()
                .get("/doodles/art-clokeys-90th-birthday")
                      .then()
                      .statusCode(200);




    }
}
