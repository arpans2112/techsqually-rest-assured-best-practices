package api.restassured.libarary.basics.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ValidateContentType {


    @Test
    public void verifyResponseIsJsonType(){

        RestAssured.baseURI = "http://api.zippopotam.us";

        given().
                when().
                get("us/90210").
                then().
                statusCode(200).
                contentType(ContentType.JSON);

    }

}
