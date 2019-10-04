package api.restassured.libarary.basics.get;

import api.zippopotam.AbstractBaseZippopotamAPIUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractReponseUsingPath extends AbstractBaseZippopotamAPIUtil {


    @Test
    public void extractResponseUsingPath(){


        String placeName = given().spec(requestSpecification).log().all().
                      when().get("us/90210").
                      then().log().all().spec(responseSpecification).statusCode(200).extract().path("places[0].'place name'");

        System.out.println("Actual PlaceName : " + placeName);
        Assert.assertEquals(placeName,"Beverly Hills");
    }
}
