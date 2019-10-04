package api.restassured.libarary.basics.get.responseType;

import api.zippopotam.AbstractBaseZippopotamAPIUtil;
import org.testng.annotations.Test;

import java.io.InputStream;

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
