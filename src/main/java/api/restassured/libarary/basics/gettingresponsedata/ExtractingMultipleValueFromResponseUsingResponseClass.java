package api.restassured.libarary.basics.gettingresponsedata;

import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ExtractingMultipleValueFromResponseUsingResponseClass extends AbstractBaseZippopotamAPIUtil {

    @Test
    public void extractingMultipleValueFromResponse(){

        /**if you have to extract one value after the validation
         *  path with single parameter*/
        Response response =   given().
                /**Setting Request Specification in AbstractBaseAPIUtil*/
                        spec(requestSpecification).log().all().
                        when().
                        get("us/90210").
                        then().log().all().
                        statusCode(200).
                        contentType(ContentType.JSON).
                        extract().response();

        /**Getting Multiple Response from the Response and validating*/

        /* get direct Node*/
        String post_Code = response.path("'post code'");
        String country = response.path("country");
        String countryAbbreviation = response.path("'country abbreviation'");

       /**List of Map as there can be Multiple places in future*/
        List<Map<String,Object>> places = response.path("places");
        String placeName =  places.get(0).get("place name").toString();
        String longitude  = places.get(0).get("longitude").toString();
        String state = places.get(0).get("state").toString();
        String stateAbbreviation = places.get(0).get("state abbreviation").toString();
        String latitude = places.get(0).get("latitude").toString();

        Assert.assertEquals(post_Code , "90210" );
        Assert.assertEquals(country , "United States" );
        Assert.assertEquals(countryAbbreviation , "US" );
        Assert.assertEquals(placeName , "Beverly Hills" );
        Assert.assertEquals(longitude , "-118.4065" );
        Assert.assertEquals(state , "California" );
        Assert.assertEquals(stateAbbreviation , "CA" );
        Assert.assertEquals(latitude , "34.0901" );


    }
}
