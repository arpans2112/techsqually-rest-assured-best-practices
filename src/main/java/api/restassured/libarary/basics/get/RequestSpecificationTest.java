package api.restassured.libarary.basics.get;

import api.zippopotam.AbstractBaseZippopotamAPIUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationTest extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void requestSpecificationTest(){
        given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
               spec(requestSpecification).log().all().
         when().
                get("us/90210").
         then().log().all().
                statusCode(200).
                contentType(ContentType.JSON);
    }

}
