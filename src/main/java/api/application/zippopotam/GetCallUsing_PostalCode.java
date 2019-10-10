package api.application.zippopotam;

import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetCallUsing_PostalCode {


    @Test
    public  void getResponseUsingZipCode(){


        RestAssured.baseURI = "http://api.zippopotam.us";

                given().
                when().
                      get("us/90210").
                then().
                    statusCode(200).
//                  assertThat().body("places.'place name'" , CoreMatchers.hasItems("Beverly Hills"));
                    assertThat().body("places[0].'place name'" , CoreMatchers.equalTo("Beverly Hills"));

    }

}
