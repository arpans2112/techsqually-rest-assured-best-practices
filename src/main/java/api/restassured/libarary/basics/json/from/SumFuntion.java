package api.restassured.libarary.basics.json.from;

import utilities.file.JsonUtils;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class SumFuntion {

    public static void main(String[] args) {

        String jsonString = JsonUtils.readJsonFileAsString("jsons","books");

        System.out.println(from(jsonString).getInt("store.book.author*.length().sum()"));

        System.out.println(from(jsonString).getInt("store.book.price*.sum()"));


    }
}
