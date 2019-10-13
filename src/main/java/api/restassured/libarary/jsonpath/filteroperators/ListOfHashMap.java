package api.restassured.libarary.jsonpath.filteroperators;

import com.jayway.jsonpath.JsonPath;
import utilities.file.JsonUtil;

import java.util.List;
import java.util.Map;

public class ListOfHashMap {

    public static void main(String[] args) {

        String jsonString = JsonUtil.readJsonFileAsString("jsonpath","jsonPathTest");

        /** Returns the List of Map using parse Funtion*/
        List<Map<String, Object>> expensiveBooks = JsonPath
                .parse(jsonString)
                .read("$.store.book[?(@.price > 10)]", List.class);

        expensiveBooks.forEach(lv -> lv.forEach((k,mv) -> {

            System.out.println(k +  " : " + mv);
        }));
    }
}
