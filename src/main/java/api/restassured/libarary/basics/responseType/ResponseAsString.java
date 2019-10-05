package api.restassured.libarary.basics.responseType;

import api.zippopotam.AbstractBaseZippopotamAPIUtil;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseAsString extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void responseAsString(){


        String responseString =   given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                        when().
                        get("us/90210").asString();
        System.out.println(responseString);
    }
}
