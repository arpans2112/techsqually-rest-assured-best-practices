package api.restassured.libarary.basics.get.responseType;

import api.zippopotam.AbstractBaseZippopotamAPIUtil;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
