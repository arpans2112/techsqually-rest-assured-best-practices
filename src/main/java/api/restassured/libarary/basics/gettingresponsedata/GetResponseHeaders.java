package api.restassured.libarary.basics.gettingresponsedata;

import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetResponseHeaders extends AbstractBaseZippopotamAPIUtil {

    @Test
    public void getHeaders(){

      Response response =  given().
                                log().all().
                                spec(requestSpecification).log().all().
                           when().
                                get("us/90210").
                           then().log().all().
                                spec(responseSpecification).
                                extract().response();

      /**cookies*/
      Map<String,String> cookies =  response.cookies();
      System.out.println(cookies);

      System.out.println( "Specific cookie value : __cfduid = " + response.cookie("__cfduid"));;

      /**Returns the object of cookies if multiple cookes are present*/
       Cookies cookies1 = response.detailedCookies();

        // Get status line
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);

       // Get status code
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);





    }

}
