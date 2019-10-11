package api.jackson.bestPractices.serialization.jsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonGetter;

//@JsonPropertyOrder
//or
//@JsonPropertyOrder(alphabetic=true)
public class MyBean {

    /*
    * We can use the @JsonPropertyOrder annotation to specify the order of properties on serialization.
    *
    * */

    public int id;
    private String name;


    public MyBean(int i, String beanTest) {
        id = i;
        name = beanTest;
    }

    @JsonGetter("name")
    public String getTheName() {
        return name;
    }
}
