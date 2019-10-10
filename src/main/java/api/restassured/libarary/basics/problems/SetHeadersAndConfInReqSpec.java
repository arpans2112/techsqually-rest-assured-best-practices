package api.restassured.libarary.basics.problems;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class SetHeadersAndConfInReqSpec {

    public static  RequestSpecification requestSpecification;
    @BeforeMethod
    public void setRequestSpecification(){

        Map<String ,String> hearders = new HashMap<String, String>(){{
                put("Accept", "application/json");
                put("PWT", "123123123123");
                put("Referer", "https://xxxxxxx.ru/");
                put("Sec-Fetch-Mode", "cors");
                put("X-Auth-Token", "123123123123");
                put("X-User-Lang","rus");
        }};

        RestAssuredConfig restAssuredConfig = new RestAssuredConfig();
        restAssuredConfig.encoderConfig(encoderConfig().
                                    appendDefaultContentCharsetToContentTypeIfUndefined(false));


         requestSpecification = new RequestSpecBuilder().
                                                    addHeaders(hearders).
                                                    setConfig(restAssuredConfig).
                                                    setBaseUri("https://xxxxx.ru").build();
    }


   @Test
    public void getCall(){

      String requestBody = "dateEnd=2019-09-17&dateStart=2019-09-17&limit=100&officeCode=270&offset=0&onlyEmpty=false&typeBasis=";

      Response response = given().
                              spec(requestSpecification).
                              body(requestBody).
                          when().
                                get().
                          then().
                              extract().response();

       System.out.println(response.body().asString());

   }



}
