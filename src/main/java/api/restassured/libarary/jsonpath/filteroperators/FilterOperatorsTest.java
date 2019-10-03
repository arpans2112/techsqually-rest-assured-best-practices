package api.restassured.libarary.jsonpath.filteroperators;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import utilities.file.JsonUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterOperatorsTest {

    public static void main(String[] args) {

        /**
         * Reading File
        *         : src\main\resources\data\jsonpath\jsonPathTest.json
         *
         *         https://github.com/json-path/JsonPath
        * */

        String jsonString = JsonUtils.readJsonFileAsString("jsonpath","jsonPathTest");

        /**
         * To get all the Authors
         * */
        List<String> authors =  JsonPath.read(jsonString, "$.store.book[*].author");
        System.out.println(authors);


        /*
        * To get all the authors
        * */
        List<String> author =   JsonPath.read(jsonString, "$..author");
        System.out.println(author);


        /**
         * Reading everything from a store
         *
         * */
        List<String> everyThingInsideStore =  JsonPath.read(jsonString, "$.store.*");
        System.out.println(everyThingInsideStore);



        Object listOfPrice =  JsonPath.read(jsonString, "$.store..price");
        System.out.println(listOfPrice);


        Object priceOfFirstBook =  JsonPath.read(jsonString, "$.store.book[0].price");
        System.out.println(priceOfFirstBook);



        List<String> thirdBook  =  JsonPath.read(jsonString, "$.store..book[2]");
        /**
         * returns : [{"category":"fiction","author":"Herman Melville","title":"Moby Dick","isbn":"0-553-21311-3","price":8.99}]
         * */


        /** In case of Negative index starts from last so it will return the second last book*/
        Object secondToLast =    JsonPath.read(jsonString, "$.store..book[-2]");
        System.out.println(secondToLast);


        /**Last Index will be exclusive and first index will be inclusive*/
        Object firstTwoBooks =    JsonPath.read(jsonString, "$.store..book[0:2]");
        System.out.println(firstTwoBooks);


        /**Last Index will be exclusive and first index will be inclusive*/
        Object lastTwoBooks =    JsonPath.read(jsonString, "$.store..book[-2:]");
        System.out.println(lastTwoBooks);


        /**it will return the books that only has isbn number*/
        Object booksWithIsbnNumber =    JsonPath.read(jsonString, "$..book[?(@.isbn)]");
        System.out.println(booksWithIsbnNumber);

        /**All books price with ciper than 10*/

        Object priceLessThan10 =    JsonPath.read(jsonString, "$..book[?(@.price < 10)]");
        System.out.println(priceLessThan10);



        /**All books price with price less than value assigned in expensive variable*/

        Object notExpensiveBooks =    JsonPath.read(jsonString, "$..book[?(@.price <= $['expensive'])]");
        System.out.println(notExpensiveBooks);



        /**
         * Regular Expression
         *
         * */

        Object authorsNameIgnoreCase =    JsonPath.read(jsonString, "$..book[?(@.author =~ /.*REES/i)]");
        System.out.println(authorsNameIgnoreCase);


        /*
        * everything in json
        * */

        Object giveMeEverything =  JsonPath.read(jsonString, "$");
        System.out.println(giveMeEverything);

        /*
        * Use of FUntion
        * Number of Books
        * */

        Object numberOfBooks =  JsonPath.read(jsonString, "$..book.length()");
        System.out.println(numberOfBooks);


        /** Returns the List of Map using parse Funtion*/
        List<Map<String, Object>> expensiveBooks = JsonPath
                .parse(jsonString)
                .read("$.store.book[?(@.price > 10)]", List.class);

        expensiveBooks.forEach(lv -> lv.forEach((k,mv) -> {

            System.out.println(k +  " : " + mv);
        }));




    }
}
