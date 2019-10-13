package api.restassured.libarary.basics.json.from;

import utilities.file.JsonUtil;

import static io.restassured.path.json.JsonPath.from;

public class SumFuntion {

    public static void main(String[] args) {

        String jsonString = JsonUtil.readJsonFileAsString("jsons","books");

        System.out.println(from(jsonString).getInt("store.book.author*.length().sum()"));

        System.out.println(from(jsonString).getInt("store.book.price*.sum()"));


    }
}
