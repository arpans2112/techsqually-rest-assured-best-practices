package utilities.api;

import io.restassured.response.Response;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class ApiResponseEvent {

  private static Response response;



  private static  Map<String, String> headers = new HashMap();
  private static  Map<String,String> responseMetaData = new HashMap<>();
  private static  String responseBody;
    private static  String serviceName;
    @NotNull
    public static String  apiResponseEventName;


    public ApiResponseEvent(Response response) {
        this.response = response;
    }


    ApiResponseEvent(Map<String, String> headers, Map<String, String> responseMetaData, String responseBody){

            this.headers = headers;
            this.responseMetaData = responseMetaData;
            this.responseBody = responseBody;

    }

    public static ApiResponseEvent build(HashMap<String,String> otherMetaData){


        response.getHeaders().asList().forEach((h) -> {
            String var10000 = (String) headers.put(h.getName(), h.getValue());
        });

        responseMetaData.put("StatusCode", "" + response.getStatusCode());
        responseMetaData.put("StatusLine", response.getStatusLine());

        responseBody = response.getBody().asString();


        if (!otherMetaData.isEmpty()){
            responseMetaData.putAll(otherMetaData);
        }

      return new ApiResponseEvent(headers,responseMetaData,responseBody);

    }



    public static Map<String, String> getHeaders() {
        return headers;
    }

    public static void setHeaders(Map<String, String> headers) {
        ApiResponseEvent.headers = headers;
    }

    public static Map<String, String> getResponseMetaData() {
        return responseMetaData;
    }

    public static void setResponseMetaData(Map<String, String> responseMetaData) {
        ApiResponseEvent.responseMetaData = responseMetaData;
    }

    public static String getResponseBody() {
        return responseBody;
    }

    public static void setResponseBody(String responseBody) {
        ApiResponseEvent.responseBody = responseBody;
    }

    public static String getServiceName() {
        return serviceName;
    }

    public static void setServiceName(String serviceName) {
        ApiResponseEvent.serviceName = serviceName;
    }

    public static String getApiResponseEventName() {
        return apiResponseEventName;
    }

    public static void setApiResponseEventName(String apiResponseEventName) {
        ApiResponseEvent.apiResponseEventName = apiResponseEventName;
    }




}
