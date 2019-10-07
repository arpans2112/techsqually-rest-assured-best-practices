package api.zippopotam;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.After;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;

public class AbstractBaseZippopotamAPIUtil {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @BeforeTest
    public void requestSpecificationBuilder(){

   /*     HashMap<String,String> abc = new HashMap<>();
        abc.put("Cache-Control","no-cache");
        abc.put("Host","api.zippopotam.us");
        abc.put("Accept-Encoding","gzip, deflate");
        abc.put("Cookie","__cfduid=d73c268f7aa8f351466d49a6a76cb9ce21570205351");
        abc.put("Connection","keep-alive");
        abc.put("Postman-Token","d0c8a5a0-7010-496c-85fc-4c7ee1f9128f");
        abc.put("User-Agent","PostmanRuntime/7.17.1");*/

     requestSpecification = new RequestSpecBuilder().
                                       setBaseUri("http://api.zippopotam.us").setProxy("wagcorppac.walgreens.com",8080).
                                       build();

     responseSpecification = new ResponseSpecBuilder().
                                          expectContentType(ContentType.JSON).
                                          expectStatusCode(200).
                                           build();


    }



}
