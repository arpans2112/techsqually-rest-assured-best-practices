package api.restassured.libarary.basics.datadriventesting;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class GetCallUsingContryCodeAndPostalCode {


    @Test(dataProviderClass = DataProviderZippopotam.class, dataProvider = "getCallUsingContryCodeAndPostalCode")
    public void getCallUsingContryCodeAndPostalCode(String countryCode , String zipCode, String expectedValue){

        RestAssured.baseURI = "http://api.zippopotam.us";

        HashMap<String,Object> pathParamTable = new HashMap<>();
        pathParamTable.put("countryCode" , countryCode);
        pathParamTable.put("zipCode" , zipCode);

        given().
                log().all().
                pathParams(pathParamTable).
        when().
                get("{countryCode}/{zipCode}").
                then().log().all().
                statusCode(200).
                assertThat().
                /**Verify the given items in the actual collection found using GPATH*/
                        body("places.'place name'" ,    hasItems(expectedValue));



    }

}
