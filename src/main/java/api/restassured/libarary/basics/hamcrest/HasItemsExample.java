package api.restassured.libarary.basics.hamcrest;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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




        // Get the response body as a string
        String responseString = get("/store").asString();
     // Get the sum of all author length's as an int. "from" is again statically imported from the JsonPath class
        int sumOfAllAuthorLengths = from(responseString).getInt("store.book.author*.length().sum()");
     // We can also assert that the sum is equal to 53 as expected.
        assertThat(sumOfAllAuthorLengths, is(53));

    }
}
