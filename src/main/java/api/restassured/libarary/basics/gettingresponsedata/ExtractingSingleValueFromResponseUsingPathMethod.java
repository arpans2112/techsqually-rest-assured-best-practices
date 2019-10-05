package api.restassured.libarary.basics.get.gettingResponseData;

import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ExtractingSingleValueFromResponseUsingPathMethod extends AbstractBaseZippopotamAPIUtil {

/**
 *
 * Use Extract path if you have to get only one value from the response and need to pass into another
 * api call.  Then only use path method.
 *
 * 1. you can use path without argument directly by passing the gpath/Jsonpath @return String
 * 2. you can use path method with arguments, - Returns ArrayList
 * @path() withNo argument
 * @returns - String
 *
 * @path() with argument
 * @returns -  ArrayList
* */

    @Test
    public void pathWithoutArgument(){

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


    @Test
    public void pathWithArgument(){

        /**Path with the arguments Returns the ArrayList*/
        ArrayList<String> placeName =   given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                        when().
                        get("us/90210").
                        then().log().all().
                        statusCode(200).
                        contentType(ContentType.JSON).
                        extract().
                        path("places.%s" , "'place name'");

       Assert.assertEquals(placeName.get(0),"Beverly Hills");

    }


}
