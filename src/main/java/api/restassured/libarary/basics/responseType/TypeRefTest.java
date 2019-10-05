package api.restassured.libarary.basics.responseType;

import api.zippopotam.AbstractBaseZippopotamAPIUtil;

import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TypeRefTest extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void typeRefTest(){


        List<Map<String, Object>> response =  given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                when().
                    get("us/90210").
                    as(new TypeRef<List<Map<String, Object>>>(){});

        System.out.println(response);
    }

}
