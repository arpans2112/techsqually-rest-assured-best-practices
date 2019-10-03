package api.restassured.libarary.basics.schemaValidation;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonScemaValidation {

    public static void main(String[] args) {


        get("/products").then()
                .assertThat()
                 .body(matchesJsonSchemaInClasspath("D:\\Automation_Project\\techsqually-rest-assured-best-practices\\src\\main\\java\\api\\restassured\\libarary\\basics\\schemaValidation\\products-schema.json"));


        /**
         * Assert json scehma valiation using hamcrest assert That method
        * */
        assertThat("jsonResponseBody", matchesJsonSchemaInClasspath("greeting-schema.json"));
    }
}
