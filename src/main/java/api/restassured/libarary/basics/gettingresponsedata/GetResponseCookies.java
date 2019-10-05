package api.restassured.libarary.basics.gettingresponsedata;

import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetResponseCookies extends AbstractBaseZippopotamAPIUtil {

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

      /**Getting Headers from the Response*/
      Headers headers =  response.headers();
      /**Getting headers as List*/
      System.out.println(headers.asList());;

      /**Get Header of Specific value*/
      String contentType = headers.getValue("Content-Type");
      System.out.println(contentType);

      String contentTypeHeaderUsingResponseObj =  response.getHeader("Content-Type");
      System.out.println(contentTypeHeaderUsingResponseObj);

      /**Number of Headers Object*/
      System.out.println("headers.size() : " + headers.size());

      /**To check if a particular header exist or Not*/
      System.out.println(  " headers.hasHeaderWithName(\"Content-Type\") " + headers.hasHeaderWithName("Content-Type"));;

      /**Check if Response has some header or Not*/
      System.out.println(headers.exist());

      /**Print the name and value of Each Header*/
      headers.forEach( h -> System.out.println(h.getName() +  " : " + h.getValue()));


    }

}
