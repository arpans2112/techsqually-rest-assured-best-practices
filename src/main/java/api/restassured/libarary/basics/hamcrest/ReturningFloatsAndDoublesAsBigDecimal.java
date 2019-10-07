package api.restassured.libarary.basics.hamcrest;

import io.restassured.RestAssured;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

public class ReturningFloatsAndDoublesAsBigDecimal {

    public static void main(String[] args) {

        given().
                config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
                when().
                get("/price").
                then();
//                body("price", is(new BigDecimal(12.12));


    }
}
