package utilities.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.file.ResourceUtils;
import utilities.yaml.TopicMetaData;

import java.io.IOException;
import java.util.Map;

public class ApiEventBuilder {

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
          this.serviceName = topicMetaData.getServiceName();
          this.schemaName = topicMetaData.getSchemaName();
          this.partition = topicMetaData.getPartition();
          this.headers = topicMetaData.getHeaders();
          this.body = topicMetaData.getDefaultBodyPath();
          this.schemaNameKey = topicMetaData.getSchemaNameKey();

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

    public ApiEventBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ApiEventBuilder topicName(String name) {
        this.topicName = topicName;
        return this;
    }

    public ApiEventBuilder schemaName(String schemaName) {
        this.schemaName = schemaName;
        return this;
    }

    public ApiEventBuilder schemaNameKey(String schemaNameKey) {
        this.schemaNameKey = schemaNameKey;
        return this;
    }

    public ApiEventBuilder buildServiceName(Object... params) {
        this.serviceName = String.format(this.serviceName, params);
        return this;
    }

    public ApiEvent build() {
        return new ApiEvent(this.body, this.name, this.topicName, this.schemaName, this.serviceName, this.headers, this.bodyKey, this.schemaNameKey, this.partition);
    }

}
