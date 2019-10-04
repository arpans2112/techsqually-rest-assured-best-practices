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

public class AbstractBaseZippopotamAPIUtil {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @BeforeTest
    public void requestSpecificationBuilder(){

     requestSpecification = new RequestSpecBuilder().
                                       setBaseUri("http://api.zippopotam.us").
                                       build();

     responseSpecification = new ResponseSpecBuilder().
                                          expectContentType(ContentType.JSON).
                                           build();


    }



}
