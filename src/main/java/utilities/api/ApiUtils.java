package utilities.api;

import utilities.BaseStep;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

public class ApiUtils extends BaseStep {




    public ApiEvent prepareApiCall( String applicationName, String yamlFileName, String apiEventName, Map<String, String> data){


              apiEventName = !apiEventName.isEmpty() ? apiEventName : UUID.randomUUID().toString();

              Map<String,Object> parameters = new HashMap<>();
              Map<String,Object> requestBodyData = new HashMap<>();

              data.forEach((k,v) -> {

                  if (k.toLowerCase().startsWith("~")){
                      parameters.put(k,v);
                  }else{
                      requestBodyData.put(k,v);
                  }

              });


             Stream paramStream = parameters.keySet().stream().sorted().filter(s -> {
                 return s.toLowerCase().startsWith("~param");
              });


             Object[] serviceNameReplace =  paramStream.map(parameters::get).toArray();

             ApiEvent apiPreparedEvent = new ApiEventBuilder().applyDefaultForTopic("dummy/api","createEmployee").buildServiceName(serviceNameReplace).name(apiEventName).build();
             this.apiEventStorage.addProducted(apiPreparedEvent);
             return apiPreparedEvent;
    }


   /* public ApiEvent sendApiCall( ApiEvent apiPreparedEvent, String responseEventName){



        Map<String,String> headers = apiPreparedEvent.getHeaders();
        String resonseEventName = !responseEventName.isEmpty() ? responseEventName : UUID.randomUUID().toString();
        Map<String,Object> requestBodyData = new HashMap<>();


        if (apiPreparedEvent.getName().equalsIgnoreCase(resonseEventName)){

            String newEventName = resonseEventName + "-request";
            apiPreparedEvent.setName(newEventName);
            this.apiEventStorage.setLastEventNameProduced(newEventName);

        }

        data.forEach((k,v) -> {

            if (k.toLowerCase().startsWith("~")){
                parameters.put(k,v);
            }else{
                requestBodyData.put(k,v);
            }

        });


        Stream paramStream = parameters.keySet().stream().sorted().filter(s -> {
            return s.toLowerCase().startsWith("~param");
        });

//             parameters.getClass();

        Object[] serviceNameReplace =  paramStream.map(parameters::get).toArray();

        ApiEvent apiPreparedEvent = new ApiEventBuilder().applyDefaultForTopic("dummy/api","createEmployee").buildServiceName(serviceNameReplace).name(apiEventName).build();
//              apiPreparedEvent.setBody();
        this.apiEventStorage.addProducted(apiPreparedEvent);
        return apiPreparedEvent;
    }
*/


}
