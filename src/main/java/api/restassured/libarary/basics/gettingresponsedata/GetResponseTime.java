package api.restassured.libarary.basics.gettingresponsedata;

import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class GetResponseTime extends AbstractBaseZippopotamAPIUtil {

    @Test
    public void getResponseTimeUsingResponseObject(){

      Response response =  given().
                                log().all().
                                spec(requestSpecification).log().all().
                           when().
                                get("us/90210").
                           then().log().all().
                                spec(responseSpecification).
                                extract().response();

      long time = response.time();
        System.out.println("time : " +  time);

       long getTime =  response.getTime();
        System.out.println(  "getTime : " + getTime);

      long timeInSeconds = response.timeIn(TimeUnit.SECONDS);
        System.out.println("timeInSeconds : " + timeInSeconds);

        long getTimeInSeconds =  response.getTimeIn(TimeUnit.SECONDS);
        System.out.println("getTimeInSeconds : " +  getTimeInSeconds);

    }


    @Test
    public void assertResponseTimeUsingHamCrest(){

       given().
                log().all().
                spec(requestSpecification).log().all().
       when().
                get("us/90210").
       then().log().all().
                spec(responseSpecification).
                time(lessThan(2000L));

    }

    @Test
    public void assertResponseTimeUsingHamCrestNegative(){

        given().
                log().all().
                spec(requestSpecification).log().all().
                when().
                get("us/90210").
                then().log().all().
                spec(responseSpecification).
                time(greaterThan(2000L));

    }

}
