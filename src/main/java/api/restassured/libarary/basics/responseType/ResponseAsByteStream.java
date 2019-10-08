package api.restassured.libarary.basics.responseType;

import api.common.applicaiton.zippopotam.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseAsByteStream extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void typeRefTest(){


        byte[] byteArrayRespnose =   given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                        when().
                        get("us/90210").asByteArray();

        System.out.println(byteArrayRespnose);
    }
}
