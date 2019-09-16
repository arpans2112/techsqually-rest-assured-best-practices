package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class ApiEventBuilder {


    private static final String PATH_TOPIC_METADATA = "topics";
    private static final Logger logger = LoggerFactory.getLogger(ApiEventBuilder.class);
    private String name;
    private String topicName;
    private String schemaName;
    private int partition;
    private Map<String, String> headers;
    private String body;
    private String schemaNameKey ;
    private String bodyKey;
    private String serviceName;

    public ApiEventBuilder() {
    }


    public ApiEventBuilder applyDefaultForTopic(String microServiceName, String yamlFileName){

        try {
          TopicMetaData topicMetaData =  ResourceUtils.readYamlResource(microServiceName,yamlFileName,TopicMetaData.class);


        } catch (IOException e) {
            throw new RuntimeException("Unable to read topic metadata : {} " +  e.getLocalizedMessage());
        }


        return this;
    }


     public ApiEventBuilder headers(Map<String,String> headers){
        this.headers = headers;
        return this;
     }

     public ApiEventBuilder body(String body){
        this.body = body;
        return this;
     }




}
