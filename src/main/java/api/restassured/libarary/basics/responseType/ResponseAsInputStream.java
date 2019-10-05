package api.restassured.libarary.basics.responseType;

import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import org.testng.annotations.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class ResponseAsInputStream extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void typeRefTest(){


        InputStream response =  given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                        when().
                        get("us/90210").asInputStream();

        System.out.println(response);
    }
}
