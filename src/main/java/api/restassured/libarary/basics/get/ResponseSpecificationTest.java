package api.restassured.libarary.basics.get;

import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class ResponseSpecificationTest extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void responseSpecificationTest(){

        given().
                /**Setting Request Specification in AbstractBaseZippopotamAPIUtil*/
                spec(requestSpecification).log().all().
        when().
                get("us/90210").
        then().log().all().
                /**Setting Response Specification build in AbstractBaseZippopotamAPIUtil*/
                spec(responseSpecification).
                statusCode(200);


    }
}
