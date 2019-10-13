package api.restassured.libarary.jsonpath.filterpredicates;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import utilities.file.JsonUtil;

import java.util.List;
import java.util.Map;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

public class FilterPredicate {


    public static void main(String[] args) {

        String jsonString = JsonUtil.readJsonFileAsString("jsonpath","jsonPathTest");

        Filter cheapFictionFilter = filter(
                where("category").is("fiction").and("price").lte(10D)
        );

        List<Map<String, Object>> books =
                JsonPath.parse(jsonString).read("$.store.book[?]", cheapFictionFilter);

        System.out.println(books);

    }
}
