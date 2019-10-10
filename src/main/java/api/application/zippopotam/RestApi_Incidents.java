package api.application.zippopotam;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.http.HTTPBuilder;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.ntlm;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestApi_Incidents {

    public static RequestSpecification requestSpecification ;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");



        requestSpecification = new RequestSpecBuilder().
                                                setBaseUri("https://xxx/api/data/v8.2/incidents").
                                                setRelaxedHTTPSValidation().
                                                setBasePath("HealthCheckApp/DetailsView").build()
                                                .auth().basic("userid", "pwd!");

    }

    @Test
    void GetIncidentAPI(){

        try{


            Response aresponse =  RestAssured.
                    given().
                    spec(requestSpecification).
                    when().
                    get().
                    then().
                    extract().
                    response();

            System.out.println("before getBody");

            String aresponseBody = aresponse.getBody().asString();

            System.out.println("response is " + aresponseBody);
        }
        catch (Exception ex){

            System.out.println(ex.toString());

        }


    }

}