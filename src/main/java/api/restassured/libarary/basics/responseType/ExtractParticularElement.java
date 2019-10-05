package api.restassured.libarary.basics.responseType;

import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractParticularElement extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void rxtractParticularElement(){


       String country =   given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                        when().
                        get("us/90210").
                 then().contentType(ContentType.JSON).
                 extract().path("country");

        System.out.println(country);
    }
}
