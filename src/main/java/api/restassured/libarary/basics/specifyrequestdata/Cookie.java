package api.restassured.libarary.basics.specifyrequestdata;

import api.common.applicaiton.zippopotam.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Cookie extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void requestSpecificationTest(){
        given().log().all().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
               spec(requestSpecification).
         when().
                get("us/90210").
         then().log().all().
                statusCode(200).
                contentType(ContentType.JSON);
    }

}
