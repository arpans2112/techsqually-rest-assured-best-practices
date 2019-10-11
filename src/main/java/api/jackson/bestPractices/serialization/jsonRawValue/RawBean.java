package api.jackson.bestPractices.serialization.jsonRawValue;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawBean {
    public String name;


    @JsonRawValue
    public String json;

    public RawBean(String my_bean, String s) {

        name =  my_bean;
        json= s;
    }
}