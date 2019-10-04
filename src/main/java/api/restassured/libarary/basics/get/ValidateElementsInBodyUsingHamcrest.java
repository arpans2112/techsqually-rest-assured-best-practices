package api.restassured.libarary.basics.get;

import io.restassured.RestAssured;
import io.restassured.config.JsonConfig;
import io.restassured.path.json.config.JsonPathConfig;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class ValidateElementsInBodyUsingHamcrest {


    @Test
    public  void validateElementsInBodyUsingHamcrest(){


        RestAssured.baseURI = "http://api.zippopotam.us";

        given().
              log().all().
              config(RestAssured.config().jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE))).
        when().
                get("us/90210").
         then().log().all().
                statusCode(200).
                  assertThat().
                 /**Verify the given items in the actual collection found using GPATH*/
                  body("places.'place name'" ,    hasItems("Beverly Hills")).
                /** Verifies if the object received is equal to passed value*/
                  body("places[0].'place name'" , equalTo("Beverly Hills")).
                /**Verify if the passed collection doesn't exist in the actual Collections*/
                  body("places.'place name'" ,    not(hasItems("Beverly Hill"))).
                /**Verify the size of the actual collection */
                  body("places.'place name'" ,  IsCollectionWithSize.hasSize(1));


    }
}
