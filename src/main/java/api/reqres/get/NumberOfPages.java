package api.reqres.get;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class NumberOfPages {

    @Test
    public void getNumberOfPages(){

        RestAssured.given().log().all().when().get("http://reqres.in/api/users?page=2").then().log().all().statusCode(200);

    }
}
