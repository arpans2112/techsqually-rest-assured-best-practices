package api.application.zippopotam;

import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.ntlm;
import static io.restassured.RestAssured.basic;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestApi_Incidents1 {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");

    }

    @Test
    void GetIncidentAPI() {

        try {


            RestAssured.baseURI = "https://xxx/api/data/v8.2";
            RestAssured.port = 80;
            RestAssured.basePath = "/incident";
            RestAssured.authentication = basic("userid", "pwd!");
            RestAssured.authentication = ntlm("uid", "pws!", null, "uat");

            RequestSpecification httpRequest = RestAssured.given();

            Response response = httpRequest.get();
        } catch (Exception ex) {

            System.out.println(ex.toString());

        }

    }
}