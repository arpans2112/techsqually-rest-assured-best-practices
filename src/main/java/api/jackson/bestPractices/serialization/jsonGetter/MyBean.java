package api.jackson.bestPractices.serialization.jsonGetter;

import com.fasterxml.jackson.annotation.JsonGetter;

public class MyBean {

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
