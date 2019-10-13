package utilities;

import utilities.api.ApiEventStorage;
import utilities.file.JsonUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class BaseStep {

    public static ApiEventStorage apiEventStorage = ApiEventStorage.getInstance();


    public String updateJson(String json, Map<String, Object> data) {
        String key;
        Object value;


        for(Iterator var3 = data.keySet().iterator(); var3.hasNext(); json = utilities.json.JsonUtil.setJsonAttribute(json, key, value)) {
            key = (String)var3.next();
            value = data.get(key);
        }

        return utilities.json.JsonUtil.prettifyJson(json);
    }



}
