package api.jackson.bestPractices.serialization.jsonAnyGetter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class ExtendableBean {


    public String name;
    public int number;
    public Map<String, String> properties;

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

}

