package api.restassured.libarary.basics.typeref;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasSize;

public class TypeRefExample {

    public static void main(String[] args) {


        // Extract
        List<Map<String, Object>> products = get("/products").as(new TypeRef<List<Map<String, Object>>>() {});

        // Now you can do validations on the extracted objects:

        assertThat(products, hasSize(2));
        assertThat(products.get(0).get("id"), equalTo(2));
        assertThat(products.get(0).get("name"), equalTo("An ice sculpture"));
        assertThat(products.get(0).get("price"), equalTo(12.5));
        assertThat(products.get(1).get("id"), equalTo(3));
        assertThat(products.get(1).get("name"), equalTo("A blue mouse"));
        assertThat(products.get(1).get("price"), equalTo(25.5));

    }


}
