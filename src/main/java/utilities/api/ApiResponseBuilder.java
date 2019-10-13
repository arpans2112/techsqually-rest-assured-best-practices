package utilities.api;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class ApiResponseBuilder {

    private static Map<String, String> headers = new HashMap();
    private static  Map<String,String> responseMetaData = new HashMap<>();
    private static  String responseBody;
    private static  String serviceName;
    @NotNull
    public static String  apiResponseEventName;


}
