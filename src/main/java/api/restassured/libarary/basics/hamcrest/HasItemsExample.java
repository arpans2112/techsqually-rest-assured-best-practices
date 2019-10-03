package api.restassured.libarary.basics.hamcrest;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.hasItems;

public class HasItemsExample {

    public static void main(String[] args) {


                when()
                        .get("/store").
                then().
                   body("store.book.findAll { it.price < 10 }.title", hasItems("Sayings of the Century", "Moby Dick"));

          /**
          *
           * When you want the list out of Response
          * */

                // Get the response body as a String
              String response = get("/store").asString();

              // And get all books with price < 10 from the response. "from" is statically imported from the JsonPath class
             List<String> bookTitles = from(response).getList("store.book.findAll { it.price < 10 }.title");


    }
}
