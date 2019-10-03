package utilities.json;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class JsonPathUtil {



    /**
     * Get Response as an Object
     *
     * */
     public static  Object readResponseAsObject(String jsonString){
         Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonString);
         return document;
     }


    /**
     * Get Response as an Object
     *
     * */
    public static  ReadContext readResponseAsReadContext(String jsonString){
        ReadContext readContext = JsonPath.parse(jsonString);
        return readContext;
    }



}
