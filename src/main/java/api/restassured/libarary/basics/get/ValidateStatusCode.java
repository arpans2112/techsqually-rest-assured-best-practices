package api.restassured.libarary.basics.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ValidateStatusCode {


    @Test
    public void validateStatusCode(){

        RestAssured.baseURI = "http://api.zippopotam.us";

        given().
                when().
                get("us/90210").
                then().
                /**Validate the http status response code*/
                statusCode(200);

    }
}
