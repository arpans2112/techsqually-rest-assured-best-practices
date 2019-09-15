package api.dummyapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ResourceUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateEmployee {

    public static void main(String[] args) {

        //Create a Employee
        HashMap<String,String> defaultProperties = ResourceUtils.getPropertiesFileAsMap("dummyapi","default-api");
        RestAssured.baseURI = defaultProperties.get("resource.baseUrl");


        int x = ((int)(Math.random() * 100000)) % 1000;
        String randomint = String.valueOf(x);

        //with extract().response() we can store the response in response variable
        Response response = given().body("{\"name\":\"Pranjay" + x + "\",\"salary\":\"200\",\"age\":\"27\"}")
                .when().post("api/v1/create")
                .then().statusCode(200).contentType("text/html")
                .extract().response(); // it will help to get the response extract in response

         //Print is use to print the reponse on console
        response.body().print();
        System.out.println(response.body().toString());;


    }

}
