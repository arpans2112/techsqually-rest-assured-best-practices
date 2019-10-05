package api.restassured.libarary.basics.get.gettingResponseData;

import api.zippopotam.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractingMultipleValueFromResponse extends AbstractBaseZippopotamAPIUtil {

    @Test
    public void extractingMultipleValueFromResponse(){

        /**if you have to extract one value after the validation
         *  path with single parameter*/
        String postCode =   given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                        when().
                        get("us/90210").
                        then().log().all().
                        statusCode(200).
                        contentType(ContentType.JSON).
                        extract().
                        path("'post code'");

        Assert.assertEquals(postCode,"90210");

    }
}
