package api.restassured.libarary.basics.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class EnableLoggingForRequestAndResponse {

    @Test
    public void enableLoggingForRequest(){

        RestAssured.baseURI = "http://api.zippopotam.us";

        given().
                /*enables logging for Request*/
                log().all().
        when().
                get("us/90210").
        then().
                statusCode(200).
                contentType(ContentType.JSON).
                /*enables logging for Response*/
                log().all();

    }
}
