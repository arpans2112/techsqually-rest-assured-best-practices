package utilities.yaml;

import java.util.HashMap;
import java.util.Map;

/*
* Clazz: will be used to read the values from the yaml file
* */
public class TopicMetaData {

    private Map<String, String> headers = new HashMap<>();
    private String schemaName;
    private String defaultBodyPath;
    private String serviceName;
    private String schemaNameKey;
    private String defaultBodyPathKey;
    private int partition;

    public TopicMetaData(){
    }


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getDefaultBodyPath() {
        return defaultBodyPath;
    }

    public void setDefaultBodyPath(String defaultBodyPath) {
        this.defaultBodyPath = defaultBodyPath;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSchemaNameKey() {
        return schemaNameKey;
    }

    public void setSchemaNameKey(String schemaNameKey) {
        this.schemaNameKey = schemaNameKey;
    }

    public String getDefaultBodyPathKey() {
        return defaultBodyPathKey;
    }

    public void setDefaultBodyPathKey(String defaultBodyPathKey) {
        this.defaultBodyPathKey = defaultBodyPathKey;
    }

    public Integer getPartition() {
        return partition;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }
}
