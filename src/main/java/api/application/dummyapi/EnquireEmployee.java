package api.application.dummyapi;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;


public class EnquireEmployee {



    public static void main(String[] args) {

        RestAssured.baseURI = "http://dummy.restapiexample.com";

      given()
                .when().get("api/v1/employee/70732")
                .then().assertThat().statusCode(200);


    }
}
