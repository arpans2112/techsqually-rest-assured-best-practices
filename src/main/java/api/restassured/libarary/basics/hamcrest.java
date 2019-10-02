package api.restassured.libarary.basics;

public class hamcrest {


//    get("/lotto").then().body("lotto.lottoId", equalTo(5));
//    get("/lotto").then().body("lotto.winners.winnerId", hasItems(23, 54));
//    get("/price").then().body("price", is(12.12f));



    /*
    *  Returns BigDecimal
    * given().
        config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
when().
        get("/price").
then().
        body("price", is(new BigDecimal(12.12));
    * */


 /*
    JSON RESPONSE :[1,2,3]
    when().
    get("/json").
    then().
    body("$", hasItems(1, 2, 3));
    */


 /*
 *
 * when().
       get("/store");
then().
       body("store.book.author.collect { it.length() }.sum()", greaterThan(50));
 *
 * */


}
