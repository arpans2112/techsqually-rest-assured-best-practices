package api.jackson.bestPractices.serialization.JsonRootName;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class JsonRootNameBean {

        public int id;
        public String name;

    public JsonRootNameBean(int i, String john) {
    id = i;
    name = john;

    }
}
