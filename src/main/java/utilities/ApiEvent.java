package utilities;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.UUID;

public class ApiEvent {
    private static final Logger logger = LoggerFactory.getLogger(ApiEvent.class);
    private String body ;
    private String name;
    private String topicName ;
    private String schemaName ;
    private String serviceName;
    private Map<String, String> headers ;
    private String bodyKey;
    private String schemaNameKey;
    private int partition;

    public ApiEvent(String body, String name, String topicName, String schemaName, String serviceName, Map<String, String> headers, String bodyKey, String schemaNameKey, int partition){
        this.name = StringUtils.isEmpty(name) ? UUID.randomUUID().toString() : name;
        this.body = body;
        this.topicName = topicName;
        this.schemaName = schemaName;
        this.serviceName = serviceName;
        this.headers = headers;
        this.bodyKey = bodyKey;
        this.schemaNameKey = schemaNameKey;
        this.partition = partition;

    }

   public static ApiEventBuilder builder() {return new ApiEventBuilder();}


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBodyKey() {
        return bodyKey;
    }

    public void setBodyKey(String bodyKey) {
        this.bodyKey = bodyKey;
    }

    public String getSchemaNameKey() {
        return schemaNameKey;
    }

    public void setSchemaNameKey(String schemaNameKey) {
        this.schemaNameKey = schemaNameKey;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }
}
