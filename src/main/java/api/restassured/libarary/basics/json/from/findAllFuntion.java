package api.restassured.libarary.basics.json.from;

import utilities.file.JsonUtils;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class findAllFuntion {


    public static void main(String[] args) {

       String jsonString = JsonUtils.readJsonFileAsString("jsons","books");

      List<String> bookTitle = from(jsonString).getList("store.book.findAll { it.price < 10 }.title");
      /*Returns : [Sayings of the Century, Moby Dick]*/
      System.out.println(bookTitle);


    }
}
