package api.restassured.libarary.basics.responseType;

import api.common.applicaiton.zippopotam.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseInResponseClass extends AbstractBaseZippopotamAPIUtil {

    @Test
    public void responseInResponseClass(){


        Response response =   given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                        when().
                        get("us/90210").
                        then().contentType(ContentType.JSON).log().all().
                        extract().response();

                        /** You can get as many values as you want from the response*/
        String country = response.path("country");
        String postCode = response.path("'post code'");

        Headers headers = response.getHeaders();

        System.out.println(country);
        System.out.println(postCode);
        System.out.println(headers.asList());
    }

}
